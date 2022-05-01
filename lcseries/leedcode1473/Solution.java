package qrxedu.leedcode1473;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int INF = Integer.MAX_VALUE;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] f = new int[m+1][n+1][target+1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                f[i][j][0] = INF;
            }
        }
        for(int i = 1;i <= m; i++){
            int house = houses[i-1];
            for(int j = 1; j <= n; j++) {
                for (int k = 1; k <= target; k++) {
                    //根据题意被划分的区域不可能大于城市的数量
                    //所以提前设置成INF
                    if(k > i){
                        f[i][j][k] = INF;
                        continue;
                    }
                    if (house != 0) {
                        if (house == j) {
                            int cur = INF;
                            for(int p = 1; p <= n; p++){
                                if(p != j){
                                    cur = Math.min(cur,f[i-1][p][k-1]);
                                }
                            }
                            f[i][j][k] = Math.min(cur,f[i-1][j][k]);
                        } else {
                            f[i][j][k] = INF;
                        }
                    } else {
                        int cur = INF;
                        for(int p = 1; p <= n; p++){
                            if(p != j){
                                cur = Math.min(cur,f[i-1][p][k-1]);
                            }
                        }
                        //因为设置的最大值是0x7fffffff,所以在加上cost[i-1][j-1]可能发生越界
                        //一个比较好的方法是把INF设置成0x3f3f3f3f,这样这里就不会越界而且也不会有其他影响.
                        f[i][j][k] = Math.min(cur,f[i-1][j][k])+cost[i-1][j-1];
                        if(f[i][j][k] < 0){
                            f[i][j][k] = INF;
                        }
                    }
                }
            }
        }
       int ans = INF;
        for(int i = 1; i <= n; i++){
            ans = Math.min(ans,f[m][i][target]);
        }
        if(ans == INF){
            return -1;
        }
        return ans;
    }
}
