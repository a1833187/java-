package qrxedu.leedcode1337;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 这道题本身应该属于提到topK问题.然后军人的数量可以用二分来统计.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        //把每行的索引加到了每行的最后..呵呵呵...
        int[][] matrix = new int[m][n+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j <= n; j++){
                if(j < n){
                    matrix[i][j] = mat[i][j];
                }else{
                    matrix[i][j] = i;
                }
            }
        }
        Arrays.sort(matrix, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int[] t1 = Arrays.copyOfRange(o1,0,o1.length-1);
                int[] t2 = Arrays.copyOfRange(o2,0,o2.length-1);
                int ans1 = check(t1);
                int ans2 = check(t2);
                return ans1 - ans2;
            }
        });
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = matrix[i][n];
        }
        return ans;
    }

    public int check(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (arr[mid] == 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        //注意当序列中没有0时,返回的值应该是arr,length本身.
        return arr[l] == 0 ? l : l+1;
    }
    @Test
    public void show(){
        int[][] mat = {{1,1,1,1,1},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,1,1,1,1}};
        System.out.println(Arrays.toString(kWeakestRows(mat,3)));
    }
}
