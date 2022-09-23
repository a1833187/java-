package qrxedu.offer;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer66 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < 4; i++){
            if(nums[i] == nums[i+1] && nums[i] != 0){
                return false;
            }
        }
        if(isV(nums)){
            return true;
        }
        int cnt = 0;
        for(int i = 0; i < 5; i++){
            if(nums[i] == 0){
                cnt++;
            }
        }
        int sum = 0;
        for(int i = cnt;i < 4; i++){
            sum += nums[i+1] - nums[i] - 1;
        }
        return sum <= cnt;

    }
    public boolean isV(int[] nums){
        return (nums[0] + 1 == nums[1] && nums[1] + 1 == nums[2]
                && nums[2] + 1 == nums[3] && nums[3] + 1 == nums[4]);
    }
}
