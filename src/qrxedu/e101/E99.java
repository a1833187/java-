package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E99 {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        int[] ans = new int[n*n];
        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = n-1; j >= 0; j--){
                ans[k++] = mat[j][i];
            }
        }
        k = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = ans[k++];
            }
        }
        return mat;
    }
}
