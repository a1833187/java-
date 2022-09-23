package qrxedu.lcseries.leedcode645;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] out = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                out[0] = nums[i];
            }
            if (nums[i] + 2 == nums[i + 1]) {
                out[1] = nums[i] + 1;
            }
        }
        if (out[1] == 0) {
            if (nums[0] == 1) {
                out[1] = 1;
            } else {
                out[1] = nums[nums.length - 1] + 1;
            }
        }
        return out;
    }
    /**
    骚解法:
    纯数学：
    1.重复的数字：sum(nums) - sum(set(nums))   set里不能存放重复元素
    2.丢失的数字：sums(1~nums.length) - sum(set(nums))
     */
    public int[] findErrorNums1(int[] nums){
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i:nums){
            hashSet.add(nums[i]);
        }
        int[] out = new int[2];
        int sum1 = 0;
        int sum2 = 0;
        for (int num : nums) {
            sum1 += num;
        }
        for( int num : hashSet){
            sum2 += num;
        }
        int sum3 = (1+nums.length)*nums.length/2;
        out[0] = sum1 - sum2;
        out[1] = sum3 - sum2;
        return out;
    }
    /*
    计数器：统计数组中每个数字出现的次数，出现次数为2的数字为重复的数字，出现次数为0的数字为丢失的数字
     */
}
