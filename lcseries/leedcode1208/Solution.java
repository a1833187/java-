package qrxedu.leedcode1208;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    int cost;
    int[] sum;
    int n;
    public int equalSubstring(String s, String t, int maxCost) {
        n = s.length();
        cost = maxCost;
        sum = new int[n+1];
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + Math.abs(s.charAt(i-1) - t.charAt(i-1));
        }
        int l = 0,r = n;
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(check(mid)){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
    public boolean check(int mid){
        for(int l = 0; l + mid - 1 < n; l++){
            int r = l + mid - 1;
            if(sum[r+1] - sum[l] <= cost){
                return true;
            }
        }
        return false;
    }
}
