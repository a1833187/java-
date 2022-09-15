package qrxedu.lcseries.leedcode34;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int l = 0,r = nums.length-1;
        int[] ans = new int[2];
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] >= target){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        if(nums[l] == target){
            ans[0] = l;
        }else{
            return new int[]{-1,-1};
        }
        l = 0;r = nums.length-1;
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(nums[mid] <= target){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        if(nums[l] == target){
            ans[1] = r;
            return ans;
        }else{
            return new int[]{-1,-1};
        }
    }
}
