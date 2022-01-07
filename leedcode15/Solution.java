package com.qrxedu.leedcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * tml；三重循环
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            if(i>0&&nums[i] == nums[i-1]){
                continue;
            }
            for(int j = i+1;j<nums.length;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                for(int k = j+1;k<nums.length;k++){
                    if(k>j+1&&nums[k]==nums[k-1]){
                        continue;
                    }
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }
}
