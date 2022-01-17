package com.qrxedu.leedcode396;

import org.junit.jupiter.api.Test;

/**
 * F(k) = F(k-1) + sum(nums) - len * nums[len - k)
 * 数组的旋转一般都是有某种规律的，即数组的旋转很可能是数学题
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int len = nums.length;
        int[] sum1 = new int[len];
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            sum1[0] += nums[i] * i;
        }
        int res = sum1[0];
        for (int i = 1; i < len; i++) {
            sum1[i] = sum1[i - 1] + sum - len * nums[len - i];
            if(res < sum1[i]){
                res = sum1[i];
            }
        }
        return res;
    }
    @Test
    public void show(){
        int[] nums = {4,3,2,6};
        System.out.println(maxRotateFunction(nums));
    }
}
