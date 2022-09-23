package qrxedu.e101;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E79 {
    public int rob (int[] nums) {
        // write code here
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] f = new int[n+1];
        f[1] = nums[0];
        int ans = f[1];
        for(int i = 2; i < n; i++){
            f[i] = Math.max(f[i-1],f[i-2]+nums[i-1]);
            ans = Math.max(f[i],ans);
        }
        Arrays.fill(f,0);
        f[1] = 0;
        for(int i = 2; i <= n; i++){
            f[i] = Math.max(f[i-1],f[i-2]+nums[i-1]);
            ans = Math.max(f[i],ans);
        }
        return ans;
    }
}
