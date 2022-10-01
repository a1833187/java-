package qrxedu.lcseries.leedcode413;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return 0;
        }
        int[] f = new int[n];
        int ans = 0;
        for(int i = 2; i < n; i++){
            f[i] = (nums[i] + nums[i-2] == 2 * nums[i-1] ? 1 + f[i-1] : 0);
            ans += f[i];
        }
        return ans;
    }
}
