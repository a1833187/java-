package qrxedu.lcseries.leedcode41;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int[] arr = new int[nums.length+2];
        for(int i : nums){
            if(i>=1&&i<=nums.length+1){
                arr[i]++;
            }
        }
        for(int i = 1; i < arr.length;i++){
            if(arr[i] == 0){
                return i;
            }
        }
        return 0;
    }

    /**
     * 原地哈希:满足空间复杂度为常数级
     * 原地哈希条件：数组的任何一个位置index上的元素应该为index+1
     */
    public int firstMissingPositive2(int[] nums){
        int len = nums.length;
        for(int i = 0; i < len; i++){
            //nums[nums[i] - 1] != nums[i]这句话的意思是当数组的该位置上的元素不满足原地哈希的条件的
            //时候进行交换使该位置上的元素满足原地哈希的条件
            //这样交换到最后不符合条件的位置即为所求的第一个整数
            if(nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]){
                swap(nums,nums[i] - 1, i);
            }
        }
        for(int i = 0; i < len; i++){
            if(nums[i] != i + 1){
                return i+1;
            }
        }
        return nums.length + 1;
    }
    public void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
