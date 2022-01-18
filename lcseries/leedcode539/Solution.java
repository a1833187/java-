package com.qrxedu.leedcode539;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.TreeSet;

/**
 * 比较恶心的地方在于排好序的时间数组 不仅要比较相邻的元素的差，也要比较第一个和最后一个的差，因为0：00 == 24：00
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int[] cur = new int[len];
        for(int i = 0; i < len; i++){
            String s = timePoints.get(i).substring(0,2) + timePoints.get(i).substring(3,5);
            cur[i] = Integer.parseInt(s);
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : cur){
            set.add(num);
        }
        if(set.size() < len){
            return 0;
        }
        if(set.size() == 1){
            return set.first()%100+(set.first()/100*60);
        }
        for(int num : cur){
            set.add(num + 2400);
        }
        int res = Integer.MAX_VALUE;
        while(set.size()!=0){
            int o1 = set.pollFirst();
            if(set.size()!=0){
                int o2 = set.first();
                int k = (o2%100-o1%100) + (o2/100-o1/100)*60;
                if(res > k){
                    res = k;
                }
            }
        }
        return res;
    }

    /*
    int[] arr = new int[timePoints.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(timePoints.get(i).substring(0, 2)) * 60 + Integer.parseInt(timePoints.get(i).substring(3));
        }
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
        return Math.min(min, arr[0] + 1440 - arr[arr.length - 1]);
     */
}
