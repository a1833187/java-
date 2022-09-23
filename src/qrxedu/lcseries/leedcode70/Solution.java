package qrxedu.lcseries.leedcode70;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int climbStairs(int n) {
        int[] f = new int[n+1];
        f[0] = 1;
        for(int i = 0; i < n; i++){
            if(i + 1 <= n){
                f[i+1] += f[i];
            }
            if(i + 2 <= n){
                f[i+2] += f[i];
            }
        }
        return f[n];
    }
}
