package qrxedu.lcseries.leedcode75;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public void sortColors(int[] nums) {
        int l = 0,r = nums.length-1;
        while(l < r){
            while(l < r && nums[l] == 0){
                l++;
            }
            if(nums[l] == 1){
                while(l < r && nums[r] != 0){
                    r--;
                }
                if(l >= r){
                    l++;
                    r = nums.length-1;
                    continue;
                }
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }else{
                while(l < r && nums[r] == 2){
                    r--;
                }
                if(l >= r){
                    return;
                }
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
            r = nums.length-1;
        }
    }
    @Test
    public void show(){
        int[] nums = {1,2,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
