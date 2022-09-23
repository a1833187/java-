package qrxedu.lcseries.leedcode239;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 * 暴力解决 timeLimitExceeded
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        int len = nums.length;
        for(int i = 0; i <= len-k;i++){
            arr.add(findMax(nums,i,i+k));
        }
        int[] output = new int[arr.size()];
        for(int i = 0 ; i <output.length;i++){
            output[i] = arr.get(i);
        }
        return output;
    }
    public int findMax(int[] nums,int begin,int end){
        int max = nums[begin];
        for(int i = begin; i < end; i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }
        return max;
    }

    /**
     * 利用单调队列
     * LinkedList 实现了Queue接口
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums == null || nums.length < 2) {return nums;}
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            while(queue.peek() <= i-k){
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.peek()];
            }
        }
        return result;
    }
}
