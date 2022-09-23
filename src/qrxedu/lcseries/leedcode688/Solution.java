package qrxedu.lcseries.leedcode688;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    static int[][] dir = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
    int len;
    double[][][] f;
    int k;
    public double knightProbability(int n, int k, int row, int column) {
        f = new double[k + 1][n][n];
        len = n;
        this.k = k;
        return dfs(0,row,column);
    }
    public double dfs(int s,int x,int y){
        if(x < 0 || x >= len || y < 0 || y >= len){
            return 0;
        }
        if(s >= k){
            return 1;
        }
        if(f[s][x][y] != 0){
            return f[s][x][y];
        }
        double ans = 0;
        for(int[] cur : dir){
            ans += dfs(s+1,cur[0]+x,cur[1]+y)/8;
        }
        f[s][x][y] = ans;
        return ans;
    }
}
