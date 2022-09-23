package qrxedu.wexam;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main14 {
    public boolean checkWon(int[][] board) {
        // write code here
        int m = board.length;
        int n = board[0].length;
        boolean w = false;
        for(int i = 0; i < m;i++){
            if(colWon(board,i,1)){
                w = true;
            }
        }
        for(int i = 0; i < n; i++){
            if(rowWon(board,i,1)){
                w = true;
            }
        }
        if(xieWon(board,1)){
            w = true;
        }
        return w;


    }
    public boolean colWon(int[][] board,int col,int key){
        int n = board[0].length;
        for(int i = 0; i < n; i++){
            if(board[col][i] != key){
                return false;
            }
        }
        return true;
    }
    public boolean rowWon(int[][] board,int row,int key){
        int m = board.length;
        for(int i = 0; i < m; i++){
            if(board[i][row] != key){
                return false;
            }
        }
        return true;
    }
    public boolean xieWon(int[][] board,int key){
        int m = board.length;
        int n = board[0].length;
        if(m != n){
            return false;
        }
        boolean flag1 = true;
        boolean flag2 = true;
        for(int i = 0; i < m; i++){
            if(board[i][i] != key){
                flag1 = false;
            }
            if(board[i][m-1-i] != key){
                flag2 = false;
            }
        }
        return flag1 || flag2;
    }
}
