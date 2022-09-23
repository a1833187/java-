package qrxedu.algorithm.day11.two;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    //自上至下，也可以自下至上
    public int minSumPath(int[][] triangle){
        if(triangle == null){
            return 0;
        }
        int row = triangle.length;
        int col = triangle[0].length;
        for(int i = 1; i < row;i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j];
                }else if(j == i){
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j-1];
                }else{
                    triangle[i][j] = Math.min(triangle[i-1][j],triangle[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        int minPath = triangle[row-1][0];
        for(int i = 1; i < col; i++){
            if(minPath < triangle[row-1][i]){
                minPath = triangle[row-1][i];
            }
        }
        return minPath;
    }
    //自下至上
    public int minSumPath1(int[][] triangle){
        if(triangle == null){
            return 0;
        }
        int row = triangle.length;
        int col = triangle[0].length;
        for(int i = row-2;i>=0;i--){
            for(int j = 0; j <= i;j++){
                    triangle[i][j] = triangle[i][j] + Math.min(triangle[i+1][j],triangle[i+1][j+1]);
            }
        }
        return triangle[0][0];
    }
}
