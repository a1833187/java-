package qrxedu.leedcode268;

/**
 * 丢失的数字:异或两次.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i = 0; i <= n; i++){
            ans ^= i;
        }
        for(int i = 0; i < n; i++){
            ans ^= nums[i];
        }
        return ans;
    }
}
