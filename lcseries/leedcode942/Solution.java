package qrxedu.leedcode942;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n+1];
        for(int i = 0; i <= n; i++){
            ans[i] = i;
        }
        int l = 0,r = 0;
        while(r < n){
            if(r < n && s.charAt(r) == 'I'){
                r++;
                l = r;
            }else{
                while(r < n && s.charAt(r) == 'D'){
                    r++;
                }
                reverse(ans,l,r);
            }
        }
        return ans;
    }
    public void reverse(int[] ans, int l ,int r){
        while(l < r){
            int tmp = ans[l];
            ans[l] = ans[r];
            ans[r] = tmp;
            l++;
            r--;
        }
    }
}
