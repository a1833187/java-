package qrxedu.leedcode64;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] minOfPath = new int[m][n];
        minOfPath[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            minOfPath[i][0] = minOfPath[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < n; i++){
            minOfPath[0][i] = minOfPath[0][i-1] + grid[0][i];
        }
        for(int i = 1;i < m; i++){
            for (int j = 1; j < n; j++){
                minOfPath[i][j] = Math.min(minOfPath[i-1][j],minOfPath[i][j-1])+grid[i][j];
            }
        }
        return minOfPath[m-1][n-1];
    }
}
