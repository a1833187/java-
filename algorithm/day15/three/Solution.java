package qrxedu.algorithm.day15.three;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean canJump(int[] nums){
        int max = 0;
        for(int i = 0; i < nums.length;i++){
            if(max >= i){
                max = Math.max(max,nums[i] + i);
                if(max >= nums.length - 1){
                    return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }
    @Test
    public void show(){
        int[] arr = {3,2,1,0,4};
        System.out.println(canJump(arr));
    }
}
