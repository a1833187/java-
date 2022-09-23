package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer39 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int time = 1;
        int num = nums[0];
        for(int i = 1; i < n; i++){
            if(time == 0){
                num = nums[i];
                time = 1;
            }else if(num != nums[i]){
                time--;
            }else if(num == nums[i]){
                time++;
            }
        }
        return num;
    }
}
