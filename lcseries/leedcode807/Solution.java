package com.qrxedu.lcseries.leedcode807;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int row = grid.length;;
        int col = grid[0].length;
        int[] rowMax = new int[row];
        int[] colMax = new int[col];
        for(int i = 0; i < row;i++){
            int max = grid[i][0];
            for(int j = 1; j < col;j++){
                if(max < grid[i][j]){
                    max = grid[i][j];
                }
            }
            rowMax[i] = max;
        }
        for(int i = 0; i < col;i++){
            int max = grid[0][i];
            for(int j = 1; j < row;j++){
                if(max < grid[j][i]){
                    max = grid[j][i];
                }
            }
            colMax[i] = max;
        }
        int res = 0;
        for(int i = 0; i < row;i++){
            for(int j = 0; j < col;j++){
                res+=Math.min(rowMax[i],colMax[j])-grid[i][j];
            }
        }
        return res;
    }

}
