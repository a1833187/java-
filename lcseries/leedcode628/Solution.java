package com.qrxedu.lcseries.leedcode628;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int out1 = nums[0]*nums[1]*nums[nums.length-1];
        int out2 = nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1];
        return Math.max(out1, out2);
    }
}
