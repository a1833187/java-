package qrxedu.leedcode213;

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
        if(n == 2){
            return Math.max(nums[0],nums[1]);
        }
        int[] f1 = new int[n-1];
        int[] f2 = new int[n-1];
        f1[0] = nums[0];
        f2[0] = nums[1];
        for(int i = 1; i < n-1; i++){
            if(i == 1){
                f1[i] = Math.max(f1[i-1],nums[i]);
                f2[i] = Math.max(f2[i-1],nums[i+1]);
            }else{
                f1[i] = Math.max(f1[i-1],f1[i-2]+nums[i]);
                f2[i] = Math.max(f2[i-1],f2[i-2]+nums[i+1]);
            }
        }
        return Math.max(f1[n-2],f2[n-2]);
    }
}
