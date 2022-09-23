package qrxedu.lcseries.leedcode1044;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    String s;
    int n;
    String ans = "";
    long[] h,p;
    int P =1313131;
    public String longestDupSubstring(String _s) {
        s = _s;
        n = s.length();
        int l = 0, r = n;
        h = new long[n + 10];
        p = new long[n + 10];
        for(int i = 0; i < n; i++){
            p[i+1] = p[i]*P;
            h[i+1] = h[i]*P + s.charAt(i);
        }
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(check(mid)){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return ans;
    }
    public boolean check(int mid){
        Set<Long> set = new HashSet<>();
        for(int l = 0; l + mid - 1 < n; l++){
            int r = l + mid - 1;
            long cur = h[r+1]-h[l]*p[r-l+1];
            if(set.contains(cur)){
                ans = s.substring(l,r+1);
                return true;
            }
            set.add(cur);
        }
        return false;
    }
    public boolean check1(int mid){
        //java中字符串作为key在得到其对应的hashCode时会遍历字符串.
        //所以check的时间复杂度为O(n*mid).总的时间复杂度为O(logn * n * mid).TTL
        Set<String> set = new HashSet<>();
        for(int l = 0; l + mid - 1 < n; l++){
            if(set.contains(s.substring(l,l+mid))){
                ans = s.substring(l,l+mid);
                return true;
            }else{
                set.add(s.substring(l,l+mid));
            }
        }
        return false;
    }
}
