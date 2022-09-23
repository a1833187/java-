package qrxedu.lcseries.leedcode1005;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * 选择某个下标 i并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] arr = Arrays.copyOf(nums,nums.length);
        Arrays.sort(arr);
        int i = 0;
        while(k != 0){
            if(i<arr.length) {
                arr[i] = -arr[i];
                k--;
                if(i+1< arr.length&&arr[i]>arr[i+1]){
                    i++;
                }
            }
        }
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }
}
