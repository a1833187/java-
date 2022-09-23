package qrxedu.lcseries.leedcode961;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n == 2){
            return nums[0];
        }
        if(nums[n/2] == nums[n/2+1]){
            return nums[n/2];
        }else{
            return nums[n/2-1];
        }
    }
}
