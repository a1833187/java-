package qrxedu.leedcode260;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2){
            return nums;
        }
        int n = nums.length;
        int[] ans = new int[2];
        int cur = 0;
        for(int num : nums){
            cur ^= num;
        }
        int k = 0;
        while(Math.abs(cur) != 1){
            cur >>= 1;
            k++;
        }
        for(int num : nums){
            if(((num>>k) & 1) == 1){
                ans[0] ^= num;
            }else{
                ans[1] ^= num;
            }
        }
        return ans;
    }
}
