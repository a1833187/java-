package qrxedu.offer;

import java.util.Arrays;

/**
 * dp:n个骰子情况下某个得分的概率可以有n-1个骰子的几个概率和得出
 * f[i][j] = f[i-k][j-1]/6.0(k = 1 .. 6)
 * 不需要考虑n-2及其之前的骰子的概率因为已经包含在n-1内部了
 *
 * @author qiu
 * @version 1.8.0
 */
public class Offer65 {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6);
        for (int i = 2; i <= n; i++) {
            double[] cur = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    cur[j + k] += dp[j] / 6.0;
                }
            }
            dp = cur;
        }
        return dp;
    }
}
