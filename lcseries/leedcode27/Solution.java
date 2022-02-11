package com.qrxedu.leedcode27;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int len = nums.length;
        int right = len;
        int res = len;
        while(left < len){
            if(nums[left] == val){
                res--;
                right--;
                while(right > left && nums[right] == val){
                    right--;
                }
                if(right > left){
                    nums[left] = nums[right];
                }
            }
            left++;
        }
        return res;
    }
}
