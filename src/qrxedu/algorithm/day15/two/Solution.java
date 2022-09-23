package qrxedu.algorithm.day15.two;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxProfit(int[] price){
        int maxProfit = 0;
        for(int i = 0; i < price.length -1; i++){
            if(price[i] < price[i+1]){
                maxProfit += price[i+1] - price[i];
            }
        }
        return maxProfit;
    }
}
