package qrxedu.lcseries.leedcode283;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int index = 0;
        for(int i : nums){
            if(i!=0){
                nums[index++] = i;
            }
        }
        for(int i = index; i < len; i++){
            nums[i] = 0;
        }
    }
    /*
    int len = nums.length;
        for(int i = 0; i < len - 1;i++){
            int count = 0;
            for(int j = 0; j < len - i - 1; j++){
                if(nums[j] == 0){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    count++;
                }
            }
            if(count==0){
                break;
     */
}
