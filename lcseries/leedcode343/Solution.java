package qrxedu.leedcode343;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    /**
     * 数学的思想：将一个整数尽可能均匀的分成k份，求这k份乘积的最大值
     * @param n
     * @return
     */
    public int integerBreak(int n) {

        int max = 0;
        for(int i = 2; i <= n; i++){
            int m = n % i;
            int x1 = n / i;
            int c = 0;
            int x2 = x1+1;
            while(m != 0){
                c++;
                m--;
            }
            max = Math.max(max,(int)Math.pow(x1,i-c)*(int)Math.pow(x2,c));
        }
        return max;
    }

    /**
     * 动态规划：dp[i]表示将整数i分成两个正整数后乘积的最大值
     * 这两个正整数分别是j 和 i-j(不继续进行拆分)或者dp[i-j](将i-j继续拆分成两个正整数)，
     * @param n
     * @return
     */
    public int integerBreak1(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            int max = 0;
            for(int j = 1; j < i; j++){
                max = Math.max(max,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
