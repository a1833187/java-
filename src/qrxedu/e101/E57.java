package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E57 {
    public boolean[][] isV;
    public int m;
    public int n;
    public int ans = 0;
    public char[][] g;
    public int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public boolean flag;
    public int solve (char[][] grid) {
        // write code here
        g = grid;
        m = grid.length;
        n = grid[0].length;
        if(m == 1 && n == 1 && g[0][0] == '1'){
            return 1;
        }
        isV = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(g[i][j] == '0'){
                    continue;
                }
                flag = false;
                if(!isV[i][j]) {
                    dfs(i, j);
                }
                if(flag){
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int x,int y){
        isV[x][y] = true;
        flag = true;
        for(int i = 0; i < 4; i++){
            int r = x + dir[i][0];
            int c = y + dir[i][1];
            if(r < 0 || r >= m || c < 0 || c >= n || isV[r][c] || g[r][c] == '0'){
                continue;
            }
            isV[r][c] = true;

            dfs(r,c);
        }
    }
    @Test
    public void show(){
        char[][] gird = {{'0','0','0','1','0','0','0'},{'0','0','0','0','0','0','1'}};
        System.out.println(solve(gird));
    }

}
