package qrxedu.lcseries.leedcode62;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] numOfPaths = new int[m+1][n+1];
        for(int i = 1;i <= m; i++){
            numOfPaths[i][1] = 1;
        }
        for(int i = 1; i <= n; i++){
            numOfPaths[1][i] = 1;
        }
        for(int i = 2; i <= m;i++){
            for(int j = 2; j <= n; j++){
                numOfPaths[i][j] = numOfPaths[i-1][j] + numOfPaths[i][j-1];
            }
        }
        return numOfPaths[m][n];
    }
    @Test
    public void show(){
        System.out.println(uniquePaths(3,7));
    }
}
