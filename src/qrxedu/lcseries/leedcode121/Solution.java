package qrxedu.lcseries.leedcode121;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfie = 0;
        int minPrice = prices[0];
        int n = prices.length;
        for(int i = 1; i < n; i++){
            if(minPrice > prices[i]){
                minPrice = prices[i];
            }
            if(minPrice < prices[i]){
                maxProfie = Math.max(maxProfie,prices[i]-minPrice);
            }
        }
        return maxProfie;
    }
}
