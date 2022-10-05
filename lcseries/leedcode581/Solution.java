package qrxedu.lcseries.leedcode581;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0,j = nums.length-1;
        while(i <= j && nums[i] == arr[i]){
            i++;
        }
        while(j >= i && nums[j] == arr[j]){
            j--;
        }
        return j - i + 1;
    }

    /**
     * 刚开始考虑的就是这个思路:左边找到第一个不满足升序条件的下标i和右边找到第一个不满足条件的下标j
     * 但是考虑的浅了,没有考虑到前面某个元素比后面某个元素大的情况
     * 所以还需要从中间开始往两边扩展最短的边界,保证左边的元素都比中间元素的小,右边的元素逗比中间元素的大
     * @param nums
     * @return
     */
    public int findUnsortedSubarray1(int[] nums) {
        int n = nums.length;
        int i = 0, j = n-1;
        while(i + 1 < n && nums[i+1] >= nums[i]){
            i++;
        }
        while(j - 1 >= 0 && nums[j] >= nums[j-1]){
            j--;
        }
        int l = i,r = j;
        for(int k = l; k <= r; k++){
            while(i>= 0 && nums[i] > nums[k]){
                i--;
            }
            while(j < n && nums[j] < nums[k]){
                j++;
            }
        }
        return j - i <= 0 ? 0 : (j-1) - (i+1) + 1;
    }
}
