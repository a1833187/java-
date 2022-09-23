package qrxedu.lcseries.leedcode53;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < f.length; i++){
            f[i] = Math.max(f[i-1]+nums[i],nums[i]);
            if(max < f[i]){
                max = f[i];
            }
        }
        return max;
    }
}
