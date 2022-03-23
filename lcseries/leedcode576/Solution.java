package qrxedu.leedcode576;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    static final int MOD = (int)1e9+7;
    int row;
    int col;
    int max;
    int[][][] map;
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        row = m;
        col = n;
        max = maxMove+1;
        map = new int[row][col][max];
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j++){
                for(int k = 0; k < max; k++){
                    map[i][j][k] = -1;
                }
            }
        }
        return dfs(startRow,startColumn,maxMove);
    }
    public int dfs(int m,int n,int k){
        if(m < 0 || m >= row || n < 0 || n >= col){
            return 1;
        }
        if(k <= 0){
            return 0;
        }
        if(map[m][n][k] != -1){
            return map[m][n][k];
        }
        int ans = 0;
        for(int i = 0; i < 4;i++){
            int lr = m + dir[i][0];
            int lc = n + dir[i][1];
            ans += dfs(lr,lc,k-1)% MOD;
        }
        map[m][n][k] = ans;
        return ans;
    }
}
