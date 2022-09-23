package qrxedu.lcseries.leedcode419;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int countBattleships(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        int ans = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i > 0 && board[i-1][j] == 'X'){
                    continue;
                }
                if(j > 0 && board[i][j-1] == 'X'){
                    continue;
                }
                if(board[i][j] == 'X'){
                    ans++;
                }
            }
        }
        return ans;
    }
}

