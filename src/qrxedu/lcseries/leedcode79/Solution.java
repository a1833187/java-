package qrxedu.lcseries.leedcode79;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean[][] isVisited;
    public boolean flag;
    public int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && board[i][j] == word.charAt(0)) {
                    isVisited[i][j] = true;
                    dfs(board, word, i, j, 1);
                    isVisited[i][j] = false;
                }
            }
        }
        return flag;
    }

    public void dfs(char[][] board, String word, int r, int c, int index) {
        if (index >= word.length()) {
            flag = true;
            return;
        }
        for (int i = 0; i < 4; i++) {
            int rc = r + dir[i][0];
            int cc = c + dir[i][1];
            if (rc >= 0 && rc < board.length && cc >= 0 && cc < board[0].length &&
                    board[rc][cc] == word.charAt(index) && !isVisited[rc][cc]) {
                isVisited[rc][cc] = true;
                dfs(board, word, rc, cc, index + 1);
                isVisited[rc][cc] = false;
            }
        }
    }
    @Test
    public void show(){
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }
}
