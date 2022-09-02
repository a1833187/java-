package qrxedu.lcseries.leedcode1030;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    static class Pair{
        int row;
        int col;
        int dis;
    }
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        Pair[] mat = new Pair[rows*cols];
        int k = 0;
        for(int i = 0; i <rows; i++){
            for(int j = 0; j < cols; j++){
                Pair p = new Pair();
                p.row = i;
                p.col = j;
                p.dis = Math.abs(rCenter-i)+Math.abs(cCenter-j);
                mat[k++] = p;
            }
        }
        Arrays.sort(mat, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.dis-o2.dis;
            }
        });
        k = 0;
        int[][] ans = new int[rows*cols][2];
        for(int i = 0; i < rows*cols; i++){
                ans[i][0] = mat[k].row;
                ans[i][1] = mat[k].col;
                k++;
            }
        return ans;
    }
}
