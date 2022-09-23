package qrxedu.e101;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E67 {
    public int uniquePaths (int m, int n) {
        //因为没有障碍物,所以也可以直接通过组合数求解C(m+n-2)(m-1  /   n-1)
        // write code here
        if(m == 1 && n == 1){
            return 1;
        }
        int[][] f = new int[m][n];
        for(int i = 1; i < m; i++){
            f[i][0] = 1;
        }
        for(int i = 1; i < n; i++){
            f[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                f[i][j] = Math.max(f[i-1][j],f[i][j-1])+1;
            }
        }
        return f[m-1][n-1];
    }
    @Test
    public void show(){
        System.out.println(uniquePaths(3,3));
    }
}
