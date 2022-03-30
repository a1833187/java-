package qrxedu.algorithm.day19;

/**
 * 硬币划分
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int count = 0;
    public int[] coins = {1,2,5,10};
    public final int MOD = (int)1e9+7;
    public int numOfCoins(int n){
        //时间复杂度比较大
        dfs(n,0);
        return count;
    }
    public void dfs(int n,int index){
        if(n <= 0){
            if(n == 0){
                count = count %MOD;
            }
            return;
        }
        for(int i = index; i < coins.length;i++){
            dfs(n-coins[i],i);
        }
    }

    public int numOfCoins1(int n){
        //背包dp
        int[][] f = new int[5][n+1];
        for(int i = 0; i <= 4; i++){
            f[0][i] = 1;
        }
        for(int i = 1; i < 4; i++){
            for(int j = 1; j <= n; j++) {
                if (j >= coins[i-1]) {
                    f[i][j] = (f[i - 1][j] + f[i][j - coins[i-1]])%MOD;
                }else{
                    f[i][j] = f[i-1][j] % MOD;
                }
            }
        }
        return f[4][n];
    }

}
