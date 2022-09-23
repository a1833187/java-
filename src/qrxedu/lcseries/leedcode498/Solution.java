package qrxedu.lcseries.leedcode498;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int k = 0;
        int r = 0;
        int c = 0;
        int[] res = new int[m*n];
        for (int i = 1; i < m + n; i++) {
            r = i < n ? 0 : i - n;
            c = i < n ? i - 1 : n - 1;
            List<Integer> list = new ArrayList<>();
            //while循环的两个条件相互限制导致数组不会越界！！！
            while(r<m&&c>=0){
                list.add(mat[r][c]);
                r++;
                c--;
            }
            if(i%2!=0){
                Collections.reverse(list);
            }
            for(int l : list){
                res[k++] = l;
            }
        }
        return res;
    }

    @Test
    public void show() {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
    }
}
