package com.qrxedu.leedcode5935;


import java.util.ArrayList;
import java.util.List;

/**
 * 非递增：递增的个数为0，即任意相邻两项后一项减前一项大于0的个数为0
 * 非递减：递减的个数为0，即任意相邻两项后一项减前一项小于0的个数为0
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> list = new ArrayList<>();
        if(security.length<2*time+1){
            return list;
        }
        if (time == 0) {
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = 0; i < security.length; i++) {
                integers.add(security[i]);
            }
            return integers;
        }
        int a1 = 0;
        int a2 = 0;
        for(int i = 1; i <=time;i++){
            if(security[i]-security[i-1]>0){
                a1++;
            }
        }
        for(int i = time+1;i<=time+time;i++){
            if(security[i]-security[i-1]<0){
                a2++;
            }
        }
        for(int i = time;i<security.length-time;i++){
            if(a1==0&&a2==0){
                list.add(i);
            }
            if(security[i-time]<security[i-time+1]){
                a1--;
            }
            if(security[i]<security[i+1]){
                a1++;
            }
            if(security[i]>security[i+1]){
                a2--;
            }
            if((i+time+1)<security.length&&security[i+time]>security[i+time+1]){
                a2++;
            }
        }
        return list;
    }
}
