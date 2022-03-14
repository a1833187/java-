package qrxedu.leedcode63;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        int[][] numOfPaths = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            if(obstacleGrid[i-1][0] != 1){
                numOfPaths[i][1] = 1;
            }else{
                break;
            }
        }
        for(int i = 1; i <= n; i++){
            if(obstacleGrid[0][i-1] != 1){
                numOfPaths[1][i] = 1;
            }else{
                break;
            }
        }
        for(int i = 2; i <= m; i++){
            for(int j = 2; j <= n; j++){
                if(obstacleGrid[i-1][j-1] != 1){
                    numOfPaths[i][j] = numOfPaths[i-1][j] + numOfPaths[i][j-1];
                }
            }
        }
        return numOfPaths[m][n];
    }
    @Test
    public void show(){
        int[][] num = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(num));
    }
}
