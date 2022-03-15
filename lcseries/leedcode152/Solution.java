package qrxedu.leedcode152;

import org.junit.jupiter.api.Test;

/**
 * 最大连续子乘积：不同于最大连续和，乘积由于存在负负得正的可能，因此每个坐标处的最小乘积也要记录。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxProduct(int[] nums) {
       int m = nums.length;
       int[] maxNums = new int[m];
       int[] minNums = new int[m];
       maxNums[0] = nums[0];
       minNums[0] = nums[0];
       int maxX = maxNums[0];
       for(int i = 1; i < m; i++){
           int min = Math.min(nums[i],nums[i]*minNums[i-1]);
           minNums[i] = Math.min(min,nums[i]*maxNums[i-1]);
           int max = Math.max(nums[i],nums[i]*minNums[i-1]);
           maxNums[i] = Math.max(max,nums[i]*maxNums[i-1]);
           maxX = Math.max(maxX,maxNums[i]);
       }
       return maxX;
    }
    @Test
    public void show(){
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
}
