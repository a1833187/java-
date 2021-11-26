package com.qrxedu.leedcode1260;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> list = new ArrayList<>();
        //按列存储
        for(int i = 0; i <grid[0].length; i++){
            List<Integer> list1 = new ArrayList<>();
            for(int j = 0; j < grid.length;j++){
                list1.add(grid[j][i]);
            }
            list.add(list1);
        }
        int row = list.size();
        int col = list.get(0).size();
        for(int i = 0; i < k; i++){
            List<Integer> list1 = list.get(row-1);
            int m = list1.get(col-1);
            list1.remove(col-1);
            list1.add(0,m);
            list.remove(row-1);
            list.add(0,list1);
        }
        List<List<Integer>> output = new ArrayList<>();
        //取行输出
        for(int i = 0; i <grid.length; i++){
            List<Integer> list1 = new ArrayList<>();
            for(int j = 0; j < grid[0].length;j++){
                list1.add(list.get(j).get(i));
            }
            output.add(list1);
        }
        return output;
    }
}
