package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E68 {
    public int minPathSum (int[][] matrix) {
        // write code here
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 1; i < m; i++){
            matrix[i][0] += matrix[i-1][0];
        }
        for(int j = 1; j < n; j++){
            matrix[0][j] += matrix[0][j-1];
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                matrix[i][j] += Math.min(matrix[i-1][j],matrix[i][j-1]);
            }
        }

        return matrix[m-1][n-1];
    }
}
