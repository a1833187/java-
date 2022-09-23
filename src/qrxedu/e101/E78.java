package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E78 {
    public int rob (int[] nums) {
        // write code here
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = Math.max(nums[0],nums[1]);
        int ans = Math.max(f[0],f[1]);
        for(int i = 2; i < n; i++){
            f[i] = Math.max(f[i-1],f[i-2]+nums[i]);
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }
}
