package qrxedu.leedcode629;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    int MOD = (int) 1e9 + 7;

    public int kInversePairs(int n, int k) {
        //设置成long,否则会越界.
        long[][] f = new long[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            f[i][0] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= i) {
                    f[i][j] = f[i - 1][j] + f[i][j - 1] - f[i - 1][j - i] + MOD;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1] + MOD;
                }
                f[i][j] = f[i][j] % MOD;
            }
        }
        return (int) f[n][k];
    }

    @Test
    public void show() {
        System.out.println(kInversePairs(2, 2));
    }
}
