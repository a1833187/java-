package qrxedu.l612;

/**
 * @author qiu
 * @version 1.8.0
 */
public class S2 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        for(int i = 0; i < n; i++){
            f[0][i] = grid[0][i];
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                f[i][j] = Integer.MAX_VALUE;
                for(int k = 0; k < n; k++){
                    f[i][j] = Math.min(f[i][j],f[i-1][k]+moveCost[grid[i-1][k]][j]);
                }
                f[i][j] += grid[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            ans = Math.min(ans,f[m-1][i]);
        }
        return ans;
    }
}
