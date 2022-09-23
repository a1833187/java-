package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E80 {
    public int maxProfit (int[] prices) {
        // write code here
        int n = prices.length;
        if(n == 0){
            return 0;
        }
        int ans = 0;
        int minP = prices[0];
        for(int i = 1; i < n; i++){
            if(prices[i] < minP){
                minP = prices[i];
            }
            if(prices[i]-minP > ans){
                ans = prices[i] - minP;
            }
        }
        return ans;
    }
}
