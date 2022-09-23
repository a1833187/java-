package qrxedu.lcseries.leedcode36;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(board[i][j] - '0');
                    cur.add(i);
                    cur.add(j);
                    list.add(cur);
                }
            }
        }
        List<List<Integer>> ls = new ArrayList<>();
        for (int j = 1; j <= 9; j++) {
            for (int i = 0; i < list.size(); i++) {
                List<Integer> cu = new ArrayList<>();
                if (list.get(i).get(0) == j) {
                    cu.add(list.get(i).get(1));
                    cu.add(list.get(i).get(2));
                    ls.add(cu);
                }

            }
            for (int i = 0; i < ls.size() - 1; i++) {
                int i1 = ls.get(i).get(0);
                int j1 = ls.get(i).get(1);
                for (int l = i + 1; l < ls.size(); l++) {
                    int i2 = ls.get(l).get(0);
                    int j2 = ls.get(l).get(1);
                    if (isValid(i1, j1, i2, j2)) {
                        return false;
                    }
                }
            }
            ls = new ArrayList<>();
        }
        return true;
    }

    public boolean isValid(int i1, int j1, int i2, int j2) {
        return (i1 == i2 || j1 == j2 || (i1/3 == i2/3 && j1/3==j2/3));
    }

    @Test
    public void show() {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
    public boolean isValidSudoku1(char[][] board) {
        //统计每个数字每行出现的次数，每列出现的次数，每个三角阵出现的次数
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
