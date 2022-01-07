package com.qrxedu.leedcode485;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = 0;
        int len1 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                len1++;
            }
            if(nums[i] == 0){
                len1 = 0;
            }
            if(len < len1){
                len = len1;
            }
        }
        return len;
    }
}
