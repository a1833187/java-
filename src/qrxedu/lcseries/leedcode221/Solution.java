package qrxedu.lcseries.leedcode221;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null){
            return 0;
        }
        int m = matrix.length;
        if(m == 0){
            return 0;
        }
        int n = matrix[0].length;
        int[][] areas = new int[m][n];
        int res = 0;
        for(int i = 0; i < m;i++){
            areas[i][0] = matrix[i][0] - '0';
            res = Math.max(res,areas[i][0]);
        }
        for(int i = 0; i < n; i++){
            areas[0][i] = matrix[0][i] - '0';
            res = Math.max(res,areas[0][i]);
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == '1'){
                    if(areas[i-1][j] != 0 && areas[i][j-1] != 0 && areas[i-1][j-1] != 0){
                        int b1 = (int)Math.min(Math.pow(areas[i-1][j],0.5),Math.pow(areas[i][j-1],0.5));
                        int b2 = (int)Math.min(b1,Math.pow(areas[i-1][j-1],0.5)) + 1;
                        areas[i][j] = (int)Math.pow(b2,2);
                    }else{
                        areas[i][j] = 1;
                    }
                    res = Math.max(res,areas[i][j]);
                }
            }
        }
        return res;
    }
}
