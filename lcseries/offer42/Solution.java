package qrxedu.offer42;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] f = new int[len];
        f[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < len; i++){
            f[i] = Math.max(f[i-1]+nums[i],nums[i]);
            max = Math.max(max,f[i]);
        }
        return max;
    }
}
