package com.qrxedu.leedcode794;

/**
 * 井字游戏
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean validTicTacToe(String[] board) {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    countX++;
                }
                if (board[i].charAt(j) == 'O') {
                    countO++;
                }
            }
        }
        int dif = countX - countO;
        if (dif >= 0 && dif <= 1) {
            if (isWin(board, 'X') && isWin(board, 'O')) {
                return false;
            }
            if(isWin(board,'X')&&dif!=1){
                return false;
            }
            if(isWin(board,'O')&&dif!=0){
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean isWin(String[] board, char chars) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == chars && board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)) {
                return true;
            }
            if (board[0].charAt(i) == chars && board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i))
            {
                return true;
            }

        }
        if (board[0].charAt(0) == chars && board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2))
        {
            return true;
        }
        if (board[0].charAt(2) == chars && board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0))
        {
            return true;
        }
        return false;
    }
}
