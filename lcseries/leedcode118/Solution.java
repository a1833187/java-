package com.qrxedu.lcseries.leedcode118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<Integer> list1 = new ArrayList<>();
        List<List<Integer>> list2 = new ArrayList<>();
        list1.add(1);
        list2.add(list1);
        for(int i = 1; i < numRows; i++){
                List<Integer> list = new ArrayList<>();
                list.add(1);
                for(int j = 0; j < list1.size()-1;j++){
                    list.add(list1.get(j)+list1.get(j+1));
                }
                list.add(1);
                list1 = list;
                if(numRows > 1) {
                    list2.add(list);
                }
        }
        return list2;
    }
}
