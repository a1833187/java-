package com.qrx.edu.eleven.leedcode5940;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length == 1){
            return 1;
        }
        int max = nums[0];
        int min = nums[0];
        int mid = nums.length/2;
        int maxB = 0;
        int minB = 0;
        for(int i = 1; i < nums.length;i++){
            if(max<nums[i]){
                max = nums[i];
                maxB = i;
            }
            if(min > nums[i]){
                min = nums[i];
                minB = i;
            }
        }
        if(maxB<mid&&minB<mid){
            return maxB>minB?(maxB+1):(minB+1);
        }
        if(maxB>=mid&&minB>=mid){
            return Math.max((nums.length - maxB), (nums.length - minB));
        }
        if(maxB<mid&&minB>=mid){
            int len1 = maxB+1+ nums.length-minB;
            int len2 =minB+1;
            int len3 = nums.length - maxB;
            return Math.min(len1,Math.min(len2,len3));
        }else{
            int len1 = minB+1+nums.length-maxB;
            int len2 = maxB+1;
            int len3 = nums.length-minB;
            return Math.min(len1,Math.min(len2,len3));
        }
    }
}
