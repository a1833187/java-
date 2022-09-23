package qrxedu.lcseries.leedcode81;

/**
 * 旋转数组II:当含有重复元素时,时间复杂度为O(n)
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0){
            return false;
        }
        if(n == 1){
            return nums[0] == target;
        }
        int l = 0,r = n - 1;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] == target){
                return true;
            }
            if(nums[mid] == nums[l] && nums[mid] == nums[r]){
                l++;
                r--;
            }else if(nums[mid] >= nums[l]){
                if(nums[l] <= target && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(target <= nums[n-1] && target > nums[mid]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return nums[l] == target;
    }
}
