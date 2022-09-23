package qrxedu.lcseries.leedcode883;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int projectionArea(int[][] grid) {
        int x = 0, y = 0, z= 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            int max = 0;
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0){
                    x++;
                }
                max = Math.max(max,grid[i][j]);
            }
            y+=max;
        }
        for(int i = 0; i < n; i++){
            int max = 0;
            for(int j = 0; j < m; j++){
                max = Math.max(max,grid[j][i]);
            }
            z+=max;
        }
        return x+y+z;
    }
}
