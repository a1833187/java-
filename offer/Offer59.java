package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer59 {
    public int[] twoSum(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        while(l < r){
            while(nums[l] + nums[r] > target){
                r--;
            }
            if(nums[l] + nums[r] ==  target){
                return new int[]{nums[l],nums[r]};
            }
            l++;
        }
        return new int[2];
    }
}
