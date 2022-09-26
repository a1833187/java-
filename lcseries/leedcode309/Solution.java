package qrxedu.lcseries.leedcode309;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] f = new int[n+1][2];
        f[1][0] = -prices[0];
        f[1][1] = 0;
        for(int i = 2; i <= n; i++){
            f[i][1] = Math.max(f[i-1][1],f[i-1][0] + prices[i-1]);
            f[i][0] = Math.max(f[i-1][0],f[i-2][1] - prices[i-1]);
        }
        return f[n][1];
    }
}
