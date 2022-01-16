package com.qrxedu.lcseries.leedcode217;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 判断重复元素
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int[] n = new int[nums.length];
        n[0] = nums[0];
        for(int i = 1; i < nums.length;i++){
            n[i] = nums[i] - nums[i-1];
            if(n[i] == 0){
                return true;
            }
        }
        return false;
    }
    @Test
    public void show(){
        int[] nums = {2,14,18,22,22};
        System.out.println(containsDuplicate(nums));
    }
}
