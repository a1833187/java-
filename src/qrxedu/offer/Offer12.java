package qrxedu.offer;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer12 {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] isV;
    char[][] b;
    int m, n;
    String key;
    boolean ans = false;

    public boolean exist(char[][] board, String word) {
        b = board;
        m = b.length;
        n = b[0].length;
        key = word;
        isV = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i][j] == key.charAt(0)) {
                    isV[i][j] = true;
                    dfs(i, j, 1);
                    isV[i][j] = false;
                }
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }

    public void dfs(int x, int y, int index) {
        if (index == key.length()) {
            ans = true;
            return;
        }
        //剪枝
        if(ans){
            return;
        }
        for (int l = 0; l < 4; l++) {
            int nx = x + dir[l][0];
            int ny = y + dir[l][1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || isV[nx][ny]) {
                continue;
            }
            if (b[nx][ny] == key.charAt(index)) {
                isV[nx][ny] = true;
                dfs(nx, ny, index + 1);
                isV[nx][ny] = false;
            }
            //剪枝
           if(ans){
               return;
           }
        }
    }

    @Test
    public void show() {
        char[][] board = {{'a', 'b'}};
        System.out.println(exist(board, "ba"));
    }
}
