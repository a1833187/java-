package qrxedu.offer;

/**
 * 奇数在前,偶数在后
 * @author qiu
 * @version 1.8.0
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        int n = nums.length;
        int l = 0,r = n-1;
        int key = nums[0];
        while(l < r){
            while(r > l && nums[r] % 2 == 0){
                r--;
            }
            nums[l] = nums[r];
            while(l < r && nums[l] % 2 == 1){
                l++;
            }
            nums[r] = nums[l];
        }
        nums[l] = key;
        return nums;
    }
}
