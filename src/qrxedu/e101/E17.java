package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E17 {
    public int search (int[] nums, int target) {
        // write code here
        int n = nums.length;
        if(n == 0){
            return -1;
        }
        int l = 0,r = n-1;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return nums[l] == target ? l : -1;
    }
}
