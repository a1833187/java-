package com.qrxedu.lcseries.leedcode453;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int minMoves(int[] nums) {
        int len = nums.length;
        int count = 0;
        while (!isEqual(nums)) {
            int k = 0;
            for (int j = 0; j < len; j++) {
                if (nums[k] < nums[j]) {
                    k = j;
                }
            }
            for (int l = 0; l < len; l++) {
                if (l != k) {
                    nums[l]++;
                }
            }
            count++;
        }
        return count;
    }

    public boolean isEqual(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void show() {
        int[] nums = {1, 1000000000};
        System.out.println(minMoves(nums));
    }

    /**
     * 官方题解：n-1个元素变大等价于1个元素变小
     */
    public int fuck(int[] nums) {
        int k = nums[0];
        int len = nums.length;
        for (int num : nums) {
            if (k > num) {
                k = num;
            }
        }
        int count = 0;
        for(int i : nums){
            count += i - k;
        }
        return count;
    }
}
