package qrxedu.lcseries.leedcode877;

/**
 * 石子游戏
 * 区间dp倒是有那么点思路.状态存储的值实在是长见识了
 * f[l][r]:存储的是[l-r]区间内先手和后手的最大差值.
 * f[l][r] = Math.max(p[l]-f[l+1][r],p[r]-f[l][r-1])
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] f = new int[n][n];
        for(int i = n-1; i >= 0; i--){
            for(int j = i + 1; j < n; j++){
                if(i == j){
                    f[i][j] = 0;
                }else{
                    f[i][j] = Math.max(piles[i]-f[i+1][j],piles[j]-f[i][j-1]);
                }
            }
        }
        return f[0][n-1] > 0;

    }
}
