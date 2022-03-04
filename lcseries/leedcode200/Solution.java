package qrxedu.leedcode200;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean[][] isVisited;
    public int count = 0;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1' || isVisited[x][y]) {
            return;
        }
        isVisited[x][y] = true;
        for (int i = 0; i < dir.length; i++) {
            int rc = x + dir[i][0];
            int cc = y + dir[i][1];
            dfs(grid, rc, cc);
        }
    }
    @Test
    public void show(){
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }
}
