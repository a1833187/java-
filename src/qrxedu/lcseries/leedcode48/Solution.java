package qrxedu.lcseries.leedcode48;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] mat = new int[m][n];
        int k1 = 0,k2 = 0;
        for(int j = 0; j < n; j++){
            for(int i = m - 1; i >= 0; i--){
                mat[k1][k2++] = matrix[i][j];
                if(k2 == n){
                    k1++;
                    k2 = 0;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = mat[i][j];
            }
        }
    }
    /*
    原地旋转,当n为偶数时，如4x4的矩阵，可以对2x2位置的元素进行遍历，每个元素和对应的另外三个位置进行转换。
    当n为奇数时，如5x4的矩阵，可以对2x3位置的元素进行遍历，除去矩阵中心处的元素不用被遍历，其他的元素和偶数时相同。
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }
     */

    /*
    顺时针旋转90°等价于先水平翻转然后再按照主对角线翻转。
     public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 主对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
     */
}
