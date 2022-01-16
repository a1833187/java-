package com.qrxedu.lcseries.leedcode1;

/**
 * 两数之和
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int m = 0;
        int[] o = new int[2];
        for(int i = 0; i < len-1;i++){
            for(int j = i+1; j < len;j++){
                if(nums[i]*nums[j] == target){
                    o[0] = i;
                    o[1] = j;
                    break;
                }
            }
        }
        return o;
    }
}
