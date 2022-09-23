package qrxedu.algorithm.day12;

/**
 * 01背包
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int backPack(int m,int[] A,int[] V){
        int n = A.length;
        int[][] f = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(A[i-1] <= j){
                    f[i][j] = Math.max(f[i-1][j],f[i-1][j-A[i-1]] + V[i-1]);
                }else{
                    f[i][j] = f[i-1][j];
                }
            }
        }
        return f[n][m];
    }

    /**
     * 由于只需要保存该行的上一行的数据，因此可以将二维数组优化成一维数组
     * @param m
     * @param A
     * @param V
     * @return
     */
    public int backPack1(int m,int[] A,int[] V){
        int[] f = new int[m+1];
        int n = A.length;
        for(int i = 1; i <= n;i++){
            //这里必须从后往前遍历，
            //因为f的更新是根据f更新之前的数据(也就是二维数组的上一行的数据)进行更新的
            //如果从前往后，那么该数组的后面数据的更新则是根据更新后的数据进行更新的。
            for(int j = m; j>=1; j--) {
                if (A[i - 1] <= j) {
                    f[j] = Math.max(f[j], f[j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return f[m];
    }
}
