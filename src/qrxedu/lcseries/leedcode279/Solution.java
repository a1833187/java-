package qrxedu.lcseries.leedcode279;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    /**
     * 时间复杂第为O(n^2.5),可以优化成O(n^2)
     * @param n
     * @return
     */
    public int numSquares(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int k = (int)Math.pow(i,0.5);
            if(k*k==i){
                dp[i] = 1;
            }else {
                for (int j = 1; j < i; j++) {
                    int num = numOfJ(j, i);
                    if (num != 0) {
                        dp[i] = Math.min(dp[i], dp[j] + num);
                    }
                }
            }
        }
        return dp[n];
    }
    public int numOfJ(int i,int j){
        int k = (int)Math.pow(j,0.5);
        for(int l = k; l >= 1;l--){
            if((j-i)%(l*l)==0){
                return (j-i)/(l*l);
            }
        }
        return 0;
    }
    public int numOfSquares1(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
    @Test
    public void show(){
        System.out.println(numSquares(12));
    }
}
