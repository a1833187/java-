package com.qrxedu.leedcode35;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else{
                return mid;
            }
        }
        if(left == right){
            if(nums[left] < target){
                return left + 1;
            }else{
                return left;
            }
        }else{
            return left;
        }
    }
}
