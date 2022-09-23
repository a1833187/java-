package qrxedu.lcseries.leedcode303;

/**
 * @author qiu
 * @version 1.8.0
 */
public class NumArray {
    public int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length+1];
        for(int i = 0; i < sums.length;i++){
            sums[i+1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sums[right+1] - sums[left];
    }
}
