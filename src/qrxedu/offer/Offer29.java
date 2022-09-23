package qrxedu.offer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0){
            return new int[0];
        }
        int n = matrix[0].length;
        int[] f = new int[m*n];
        int x = 0;
        int k = 0;
        while(k < f.length){
            for(int i = x; i < n-1-x;i++){
                f[k++] = matrix[x][i];
                if(k == f.length){
                    return f;
                }
            }
            for(int i = x; i < m-1-x;i++){
                f[k++] = matrix[i][n-1-x];
                if(k == f.length){
                    return f;
                }
            }

            for(int i = n-1-x;i > x;i--){
                f[k++] = matrix[m-x-1][i];
                if(k == f.length){
                    return f;
                }
            }
            for(int i = m-1-x;i > x; i--){
                f[k++] = matrix[i][x];
                if(k == f.length){
                    return f;
                }
            }
            x++;
            if(k == f.length - 1){
                f[k++] = m*n == 1 ? matrix[0][0] : matrix[x][x];
            }
        }
        return f;
    }
    @Test
    public void show(){
        int[][] m = {{6,9,7}};
        System.out.println(Arrays.toString(spiralOrder(m)));
    }
}
