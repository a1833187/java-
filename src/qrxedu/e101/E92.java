package qrxedu.e101;

import java.util.HashSet;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E92 {
    public int maxLength (int[] arr) {
        // write code here
        int n = arr.length;
        int ans = 0;
        HashSet<Integer> set =  new HashSet<>();
        int l = 0,r = -1;
        while(r+1 < n){
            while(r+1 < n && (set.isEmpty() || !set.contains(arr[r+1]))){
                r++;
                set.add(arr[r]);
            }
            ans = Math.max(r-l+1,ans);
            set.remove(arr[l]);
            l++;
        }
        return ans;
    }
}
