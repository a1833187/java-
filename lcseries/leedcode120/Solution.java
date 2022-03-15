package qrxedu.leedcode120;

import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] minPaths = new int[m][n];
        for(int i = 0; i < n; i++){
            minPaths[m-1][i] = triangle.get(m-1).get(i);
        }
        for(int i = m-2;i >= 0;i--){
            for(int j = 0; j <= i; j++){
                minPaths[i][j] = triangle.get(i).get(j) + Math.min(minPaths[i+1][j],minPaths[i+1][j+1]);
            }
        }
        return minPaths[0][0];
    }
}
