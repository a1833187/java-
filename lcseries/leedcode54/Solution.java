package com.qrxedu.leedcode54;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        int total = m * n;
        while (total >= 1) {
            //每个循环必须增加一个total>=1的条件，否在螺旋结构的最内层会发生多添加的情况。！！！
            for (int i = left; i <= right && total>=1; i++) {
                list.add(matrix[top][i]);
                total--;
            }
            top++;
            for(int i = top; i <= bottom&& total>=1;i++){
                list.add(matrix[i][right]);
                total--;
            }
            right--;
           for(int i = right; i >= left && total>=1;i--){
               list.add(matrix[bottom][i]);
               total--;
           }
           bottom--;
           for(int i = bottom; i >= top && total>=1;i--){
               list.add(matrix[i][left]);
               total--;
           }
           left++;
        }
        return list;

        /*
          List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0,j = 0;
        int total = m * n;
        while(total >= 1){
            int tmpI = i;
            int tmpJ = j;
            while(j < n - tmpJ&&i == tmpI&&total>=1){
                total--;
                list.add(matrix[i][j]);
                j++;
            }
                j--;
                i++;
            while(i < m - tmpI && j == n - tmpJ - 1&&total>=1){
                total--;
                list.add(matrix[i][j]);
                i++;
            }
                i--;
                j--;
            while(j >= tmpJ && i == m - tmpI - 1&&total>=1){
                total--;
                list.add(matrix[i][j]);
                j--;
            }
                j++;
                i--;
            while(i > tmpI && j == tmpJ&&total>=1){
                total--;
                list.add(matrix[i][j]);
                i--;
            }
                i++;
                j++;
        }
        return list;
        代码没问题，主要恶心的地方是总循环的条件是total >= 1 以及 每个单循环都要进行一次total >= 1的判断
         */
    }

    @Test
    public void show() {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(m));
    }
}
