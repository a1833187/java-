package qrxedu.leedcode122;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int[] dp = new int[prices.length];
        for(int i =1; i < dp.length; i++){
            dp[i] = Math.max(dp[i-1],dp[i-1] + prices[i] - prices[i-1]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
