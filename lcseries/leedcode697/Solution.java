package com.qrxedu.lcseries.leedcode697;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 先统计数组度最大的对应的元素，然后根据元素去寻找最短连续子数组
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<Integer, Integer>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int k = 0;
        Set<Integer> set = map.keySet();
        for(int i : set){
            if(k < map.get(i)){
                k = map.get(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i : set){
            if(map.get(i) == k){
                list.add(i);
            }
        }
        int be = 0;
        int af = 0;
        int len = nums.length;
        while(list.size()!=0){
            int res = list.get(0);
            for(int i = 0; i < nums.length;i++){
                if(nums[i] == res){
                    be = i;
                    break;
                }
            }
            for(int i = nums.length-1;i>=0;i--){
                if(nums[i] == res){
                    af = i;
                    break;
                }
            }
            if(len > af - be + 1){
                len = af - be + 1;
            }
            list.remove(0);
        }
        return len;

    }
    @Test
    public void show(){
       int[] nums = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(nums));
    }
}
