package qrxedu.leedcode713;

import org.junit.jupiter.api.Test;

/**
 * 滑动窗口
 * 以右端点结尾的满足条件的子数组的大小.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int n = nums.length;
        int ans = 0;
        int sum = 1;
        int i = 0,j = 0;
        for(;i < n; i++){
            sum*=nums[i];
            while(j <= i && sum >= k){
                sum/=nums[j];
                j++;
            }
            ans += j-i+1;
        }

        return ans;
    }
    @Test
    public void show(){
        int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        System.out.println(numSubarrayProductLessThanK(nums,19));
    }
}
