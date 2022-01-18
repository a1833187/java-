package com.qrxedu.leedcode73;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 && !isVisited[i][j]) {
                    for (int k = 0; k < m; k++) {
                        if(matrix[k][j] != 0) {
                            matrix[k][j] = 0;
                            isVisited[k][j] = true;
                        }
                    }
                    for (int l = 0; l < n; l++) {
                        if(matrix[i][l] != 0) {
                            matrix[i][l] = 0;
                            isVisited[i][l] = true;
                        }
                    }
                }
            }
        }
    }
    /*
     空间复杂度为O(1)的做法：
     1. 首先设置一个标记点记录数组的第一列中是否有元素为0，
     2. 然后判断除去第一行、第一列中的其他元素是否有0存在，如果，就把所在位置的"有效0"设置到它所在的第一行和第一列。
     这样做的目的是为了方便后续判断除去第一行和第一列的剩下的元素是否要变为0
     3. 然后再后序遍历的时候要从最后一行第二列开始往右上角遍历，当其所在位置的行首元素或者列首元素为0时该元素本身要置为0
      public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }

     */
}
