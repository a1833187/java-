package qrxedu.lcseries.leedcode462;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] sum = new int[n+1];
        for(int i = 0; i < n; i++){
            sum[i+1] = sum[i] + nums[i];
        }
        long ans = Long.MAX_VALUE;
        for(int i = 0; i < n; i++){
            long front = sum[i]-sum[0];
            long fear = sum[n] - sum[i+1];
            long tmp = (long) nums[i] *i-front + fear - (long) nums[i] *(n-i-1);
            ans = Math.min(ans,tmp);
        }
        return (int)ans;
    }
    @Test
    public void show(){
        int[] nums = {1,10,2,9};
        System.out.println(minMoves2(nums));
    }
}
