package qrxedu.lcseries.leedcode198;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] f = new int[n];
        f[0] = nums[0];
        for(int i = 1; i < n; i++){
            if(i == 1){
                f[i] = Math.max(f[i-1],nums[i]);
            }else{
                f[i] = Math.max(f[i-1],nums[i] + f[i-2]);
            }
        }
        return f[n-1];
    }
}
