package qrxedu.lcseries.leedcode209;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr]
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length;i++){
            sum+=nums[i];
            if(nums[i] == target){
                return 1;
            }
        }
        if(sum < target){
            return 0;
        }
        sum = 0;
        int min =Integer.MAX_VALUE;
        LinkedList<Integer> queue = new LinkedList<>();
        int i = 0;
        while (i < nums.length){
            while(i < nums.length&&sum < target){
                queue.addLast(nums[i]);
                sum+=queue.peekLast();
                i++;
            }
            while(sum>=target){
                if(min >= queue.size()){
                    min = queue.size();
                }
                int e = queue.poll();
                sum-=e;
            }
        }
        return min;
    }
    @Test
    public void show(){
        int arr[] = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target,arr));
    }
}
