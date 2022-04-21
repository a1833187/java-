package qrxedu.leedcode1155;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int MOD = (int)Math.pow(10,9)+7;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] f = new int[n+1][target+1];
        f[0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= target; j++){
                for(int l = 1; l <= k; l++) {
                    if (j >= l) {
                        f[i][j] = (f[i][j] + f[i - 1][j - l]) % MOD;
                    }
                }
            }
        }
        return f[n][target];
    }
}
