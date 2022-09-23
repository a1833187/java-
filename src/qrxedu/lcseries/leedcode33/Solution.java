package qrxedu.lcseries.leedcode33;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        int n = nums.length;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[0] <= nums[mid]){
                // 证明mid是在左侧有序数组中
                if(nums[0] <= target && target < nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                // 证明mid是在右侧有序数组中
                if(nums[mid] < target && target <= nums[n-1]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return nums[l] == target ? l : -1;
    }
    @Test
    public void show(){
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr,0));
    }
}
