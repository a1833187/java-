package com.qrxedu.lcseries.leedcode689;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个整数 k ，
 * 找出三个长度为 k 、互不重叠、且3 * k 项的和最大的子数组，并返回这三个子数组。
 * 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。
 * 如果有多个结果，返回字典序最小的一个。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] range = new int[len];
        int[] left = new int[len];
        int sum = 0;
        for(int i = 0; i < k;i++){
            sum+=nums[i];
        }
        range[k-1] = sum;
        //存放左边数组的最大和的最后下标
        left[k-1] = k-1;
        int max = sum;
        for(int i = k; i < len; i++){
            sum = sum + nums[i] - nums[i-k];
            range[i] = sum;
            left[i] = left[i - 1];
            if(max < sum){
                max = sum;
                left[i] = i;
            }
        }
        sum = 0;
        int[] right = new int[len];
        for(int i = len-k;i<len;i++){
            sum+=nums[i];
        }
        right[len-k] = len-k;
        max = sum;
        for(int i = len-k-1;i >=0;i--){

            sum = sum + nums[i] - nums[i+k];
            right[i] = right[i+1];
            if(max <= sum){
                max = sum;
                right[i] = i;
            }
        }
        max = 0;
        int pre = 0,mid = 0,end = 0;
        int a = 0,b = 0,c = 0;
        for(int i = 2*k-1; i <len - k;i++){
            pre = range[left[i-k]];
            mid = range[i];
            end = range[right[i+1] + k-1];
            if(max < pre + mid + end){
                max = pre + mid + end;
                a = left[i-k]-k+1;
                b = i-k+1;
                c = right[i+1];
            }
        }
        return new int[]{a,b,c};
    }
    @Test
    public void show(){
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2)));
    }
    /*
        解题思路：
          从中间的数组开始遍历寻找中间数组的左边不重叠的和最大的数组和右边不重叠的和最大的数组
          1.首先设置一个数组用来存放连续三个数的和(滑动窗口)
          2.分别设置一个左数组和右数组分别来存放和最大的数组的下标
          3.为了不重叠，设定左数组存放的是三个数的右下标，右数组存放的是三个数的左下标
          4.存放下标时只存放相邻的和最大的下标，这样使本来不连续的三个数组组成了物理上连续的数组
            因为左数组和右数组存放的下标对应的和是递增的，所以每个中间数组的左边"最近的"数组和右边的"最近的"数组加起来的和
            一定是以该中间数组为中间数组的和最大的组合
     */

}
