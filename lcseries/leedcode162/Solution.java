package qrxedu.leedcode162;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1 || nums[0] > nums[1]){
            return 0;
        }
        if(nums[n-1] > nums[n-2]){
            return n-1;
        }
        int l = 1,r = n-2;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] < nums[mid - 1]){
                r = mid - 1;
            }else if(nums[mid] < nums[mid + 1]){
                l = mid + 1;
            }else{
                return mid;
            }
        }
        return l;

    }
}
