package qrxedu.leedcode1137;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int tribonacci(int n) {
        int[] f = new int[n+1];
        f[0] = 0;
        if(n == 0){
            return 0;
        }
        f[1] = 1;
        if(n == 1 || n == 2){
            return 1;
        }
        f[2] = 1;
        for(int i = 3; i <= n; i++){
            f[i] = f[i-1] + f[i-2] + f[i-3];
        }
        return f[n];
    }
}
