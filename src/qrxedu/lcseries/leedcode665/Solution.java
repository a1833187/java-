package qrxedu.lcseries.leedcode665;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1]){
                if(i > 0 && i < nums.length - 2 && nums[i-1] > nums[i+1]){
                    return false;
                }else {
                    count++;
                }
            }
        }
        return count <= 1;
    }
}
