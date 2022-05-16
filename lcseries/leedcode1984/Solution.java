package qrxedu.leedcode1984;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int minimumDifference(int[] nums, int k) {
        if(k == 1){
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for(int i = k-1; i < n; i++){
            ans = Math.min(ans,nums[i] - nums[i-k+1]);
        }
        return ans;
    }
    @Test
    public void show(){
        int[] nums = {9,4,1,7};
        System.out.println(minimumDifference(nums,2));
    }
}
