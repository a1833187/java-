package qrxedu.algorithm.day3.two;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    //青蛙跳台阶
    /*
        dp[n]:青蛙跳上第n级台阶的跳法。显然dp[n] = dp[n-1] + dp[n-2]
        定义初始值dp[0] = dp[1] = 1,dp[2] = 2.
        dp[0] = 1?要满足dp[n] = dp[n-1] + dp[n-2]，显然dp[1] = 1,dp[2] = 2
     */
    public int jumpT(int n){
        if(n < 2){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < dp.length; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
