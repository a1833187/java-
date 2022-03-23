package qrxedu.leedcode837;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public double new21Game(int n, int k, int maxPts) {

        double[] dp = new double[k+maxPts];
        for(int i = k; i <= n && i < k+maxPts;i++){
            dp[i] = 1.0;
        }
        dp[k-1] = Math.min(n-k+1,maxPts)*1.0/maxPts;
        for(int i = k-2; i >=0;i--){
            dp[i] = dp[i+1] + (dp[i+1]-dp[i+1+maxPts])/maxPts;
        }
        return dp[0];
    }
}
