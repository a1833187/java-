package com.qrxedu.lcseries.leedcode219;

import java.util.LinkedList;

/**
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，
 * 使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。

 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < nums.length;i++) {
            if (!queue.isEmpty() && queue.contains(nums[i])) {
                return true;
            }
            queue.addLast(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
            return false;
    }
}
