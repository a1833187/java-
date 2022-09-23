package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer68 {
    public int maxProfit(int[] prices) {
        int price = Integer.MAX_VALUE;
        int profit = 0;
        int len = prices.length;
        for(int i = 0; i < len; i++){
            if(prices[i] < price){
                price = prices[i];
            }else if(prices[i] - price > profit){
                profit = prices[i] - price;
            }
        }
        return profit;
    }
}
