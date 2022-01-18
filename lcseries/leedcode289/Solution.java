package com.qrxedu.leedcode289;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public void gameOfLife(int[][] board) {
        int[] neigh = {1,0,-1};
        int m = board.length;
        int n = board[0].length;
        int[][] cur = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                cur[i][j] = board[i][j];
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = 0;
                for(int k = 0; k < 3; k++){
                    for(int l = 0; l < 3; l++){
                        if(!(neigh[k] == 0&&neigh[l] == 0)){
                            int r = i + neigh[k];
                            int c = j + neigh[l];

                            if(r>=0&&r<m&&c>=0&&c<=n&&cur[r][c] == 1){
                                count ++;
                            }
                        }
                    }
                }
                if(board[i][j] == 1 && (count < 2 || count > 3)){
                    board[i][j] = 0;
                }
                if(board[i][j] == 0 && count == 3){
                    board[i][j] = 1;
                }
            }
        }
    }
}
