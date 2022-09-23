package qrxedu.lcseries.leedcode169;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int num = nums[0];
        int time = 1;
        for(int i = 1; i < n; i++){
            if(time == 0){
                time = 1;
                num = nums[i];
            }else{
                if(num == nums[i]){
                    time++;
                }else{
                    time--;
                }
            }
        }
        return num;
    }
}
