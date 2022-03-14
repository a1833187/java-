package qrxedu.leedcode55;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean canJump(int[] nums) {
        boolean[] canJump = new boolean[nums.length];
        canJump[0] = true;
        for(int i = 1; i < nums.length; i++){
            for(int k = 0; k < i; k++){
                if(nums[k] >= i-k){
                    canJump[i] = true;
                    break;
                }
            }
        }
        return canJump[nums.length-1];
    }
}
