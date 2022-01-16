package com.qrxedu.lcseries.leedcode119;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= rowIndex;i++){
            List<Integer> list1 = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    list1.add(1);
                }else{
                    list1.add(list.get(j)+list.get(j-1));
                }
            }
            list = list1;
        }
        return list;
    }
}
