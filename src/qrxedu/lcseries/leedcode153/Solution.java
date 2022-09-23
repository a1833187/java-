package qrxedu.lcseries.leedcode153;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int key = nums[0];
        int l = 0, r = n - 1;
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(nums[mid] > key){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l == n-1 ? nums[0] : nums[l+1];
    }
}
