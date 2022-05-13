package qrxedu.leedcode053;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int cnt = 0;
        int l = 0, r = n-1;
        while(l <= r){
            if(l == r && nums[l] != target){
                break;
            }
            int mid = (l+r)>>1;
            if(nums[mid] == target){
                for(int i = mid ; i < n; i++){
                    if(nums[i] == target){
                        cnt++;
                    }else{
                        break;
                    }
                }
                for(int i = mid - 1; i >= 0; i--){
                    if(nums[i] == target){
                        cnt++;
                    }else{
                        break;
                    }
                }
                return cnt;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return cnt;
    }
    @Test
    public void show(){
        int[] nums = {5,7,7,8,8,10};
        System.out.println(search(nums,8));
    }
}
