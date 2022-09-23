package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E19 {
    public int findPeakElement (int[] nums) {
        // write code here
        int n = nums.length;
        if(n == 1){
            return 0;
        }
        int l = 0,r = n-1;
        if(nums[0] > nums[1]){
            return 0;
        }
        if(nums[n-1] > nums[n-2]){
            return n-1;
        }
        while(l < r){
            int mid = l + r >> 1;
            if(mid + 1 < n && nums[mid] < nums[mid+1]){
                l = mid + 1;
            }else if(mid - 1 >= 0 && nums[mid] < nums[mid-1]){
                r = mid - 1;
            }else{
                return mid;
            }
        }
        return l;
    }
}
