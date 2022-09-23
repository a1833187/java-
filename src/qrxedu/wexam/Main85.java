package qrxedu.wexam;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main85 {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(Arrays.toString(clockwisePrint(mat, 4, 4)));
    }
    public static int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        boolean[][] isVisited = new boolean[n][m];
        int[] ans = new int[n*m];
        int k = 0;
        int x = 0;
        while(k < ans.length){
            for(int i = x; i <= m-1-x; i++){
                if(!isVisited[x][i]) {
                    isVisited[x][i] = true;
                    ans[k++] = mat[x][i];
                }
            }
            for(int i = x; i <= n-1-x;i++){
                if(!isVisited[i][m-1-x]){
                    isVisited[i][m-1-x] = true;
                    ans[k++] = mat[i][m-1-x];
                }
            }
            for(int i = m-1-x; i >= x; i--){
                if(!isVisited[n-1-x][i]){
                    isVisited[n-1-x][i] = true;
                    ans[k++] = mat[n-1-x][i];
                }
            }
            for(int i = n-1-x;i>=x;i--){
                if(!isVisited[i][x]){
                    isVisited[i][x] = true;
                    ans[k++] = mat[i][x];
                }
            }
            x++;
        }
        return ans;
    }
}
