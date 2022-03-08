package qrxedu.leedcode31;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0){
            if(nums[i] < nums[i+1]){
                break;
            }
            i--;
        }
        int j = nums.length-1;
        if(i >= 0){
            for(;j>i;j--){
                if(nums[j] > nums[i]){
                    break;
                }
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);

    }
    public void reverse(int[] nums,int i){
        int left = i;
        int right = nums.length-1;
        while(left < right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
