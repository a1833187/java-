package qrxedu.lcseries.leedcode566;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;
        if(r*c<m*n){
            return mat;
        }
        int k1  = 0, k2 = 0;
        int[][] res = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c;j++){
                res[i][j] = mat[k1][k2++];
                if(k2 == n){
                    k1++;
                    k2 = 0;
                }
            }
        }
        return res;
    }

    @Test
    public void show(){
        int[][] mat = {{1,2},{3,4}};
        System.out.println(Arrays.deepToString(matrixReshape(mat, 1, 4)));
    }
}
