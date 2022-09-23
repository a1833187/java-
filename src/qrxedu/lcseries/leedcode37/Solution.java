package qrxedu.lcseries.leedcode37;

import java.util.ArrayList;
import java.util.List;

/**
 * 解数独
 * 精华:将没有填的位置存储到数组里,从而使其在物理上连续,方便回溯
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    private char[][] b;
    private boolean isV = false;
    private List<int[]> cache = new ArrayList<>();
    public void solveSudoku(char[][] board) {
        b = new char[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    cache.add(new int[]{i,j});
                }
                b[i][j] = board[i][j];
            }
        }
        dfs(board,0);
    }
    private void dfs(char[][] board,int cnt){
        if(cnt == cache.size()){
            isV = true;
            return;
        }
        int r = cache.get(cnt)[0];
        int c = cache.get(cnt)[1];
        for(int i = 1; i <= 9 && !isV; i++){
            b[r][c] = (char)('0'+i);
            board[r][c] = (char)('0'+i);
            if(isValid(b,r,c)){
                dfs(board,cnt+1);
            }
            b[r][c] = '.';
        }

    }
    private boolean isValid(char[][] board, int r,int c){
        int row = r / 3 * 3;
        int col = c / 3 * 3;
        int[] cnt = new int[10];
        for(int i = row; i < row + 3; i++){
            for(int j = col; j < col + 3; j++){
                if(board[i][j] == '.'){
                    continue;
                }else{
                    cnt[board[i][j]-'0']++;
                }
                if(cnt[board[i][j]-'0'] > 1){
                    return false;
                }
            }
        }
        cnt = new int[10];
        for(int i = 0; i < 9; i++){
            if(board[r][i] == '.'){
                continue;
            }else{
                cnt[board[r][i]-'0']++;
            }
            if(cnt[board[r][i]-'0'] > 1){
                return false;
            }
        }
        cnt = new int[10];
        for(int i = 0; i < 9; i++){
            if(board[i][c] == '.'){
                continue;
            }else{
                cnt[board[i][c]-'0']++;
            }
            if(cnt[board[i][c]-'0'] > 1){
                return false;
            }
        }
        return true;

    }
}
