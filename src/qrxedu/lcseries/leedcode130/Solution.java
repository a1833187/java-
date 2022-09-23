package qrxedu.lcseries.leedcode130;

/**
 * 围绕的区域
 * 从边界出发深度遍历并标记不满足条件的！！！
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if(m < 2 || n < 2){
            return;
        }
        for(int i = 0; i < n;i++){
            dfs(board,0,i);
            dfs(board,m-1,i);
        }
        for(int i = 0; i < m;i++){
            dfs(board,i,0);
            dfs(board,i,n-1);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'Q'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board,int i, int j){
        int m = board.length;
        int n = board[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'Q';
        for(int l = 0; l < dir.length;l++){
            int rc = i + dir[l][0];
            int cc = j + dir[l][1];
            dfs(board,rc,cc);
        }
    }
}
