package com.qrxedu.lcseries.leedcode594;

import java.util.Arrays;

/**
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 *现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
 * 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int begin = 0;
        int count = 0;
        for(int end = 0; end < len; end++){
            while(nums[end] - nums[begin] > 1){
                begin++;
            }
            if(nums[end] - nums[begin] == 1){
                count = Math.max(count,end-begin+1);
            }
        }
        return count;
    }

}
