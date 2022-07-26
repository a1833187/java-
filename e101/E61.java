package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E61 {
    public int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public int n;
    public int m;
    public int solve (int[][] matrix) {
        // write code here
        n = matrix.length;
        m = matrix.length;
        int ans = 1;
        int[][] f = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(f[i],1);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                f[i][j] = dfs(matrix,f,i,j);
                ans = Math.max(ans,f[i][j]);
            }
        }
        return ans;
    }
    public int dfs(int[][] ma,int[][] f,int x,int y){
        if(f[x][y] != 1){
            return f[x][y];
        }
        for(int i = 0; i < 4; i++){
            int nx = x +dir[i][0];
            int ny = y + dir[i][1];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || ma[nx][ny] <= ma[x][y]){
                continue;
            }
            f[x][y] = Math.max(f[x][y],dfs(ma,f,nx,ny)+1);
        }
        return f[x][y];
    }
    @Test
    public void show(){
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(solve(arr));
    }
}
