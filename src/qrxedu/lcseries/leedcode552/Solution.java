package qrxedu.lcseries.leedcode552;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    int MOD = (int)(Math.pow(10,9)+7);
    public int checkRecord(int n) {
        //f[i][j][k]:前i天缺勤天数为j且结尾连续迟到天数为k时的数量
        int[][][] f = new int[n+1][2][3];
        f[0][0][0] = 1;
        //第i天的纪录为缺勤,f[i][1][0] += f[i-1][0][k]
        //第i天的纪录为出勤,f[i][j][0] += f[i-1][j][k]
        //第i天的纪录为迟到,f[i][j][k] += f[i-1][j][k-1], k <= 2
        for(int i = 1; i <= n; i++) {
            for (int k = 0; k < 3; k++) {
                f[i][1][0] = (f[i][1][0] + f[i - 1][0][k]) % MOD;
            }
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    f[i][j][0] = (f[i][j][0] + f[i - 1][j][k]) % MOD;
                }
            }
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    f[i][j][k] = (f[i][j][k] + f[i - 1][j][k - 1]) % MOD;
                }
            }
        }
        int sum = 0;
        for(int j = 0; j < 2; j++){
            for(int k = 0; k < 3; k++){
                sum= (sum + f[n][j][k])%MOD;
            }
        }
        return sum;
    }
}
