package qrxedu.lcseries.leedcode414;

import org.junit.jupiter.api.Test;

/**
 * O(n)时间复杂度
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int thirdMax(int[] num) {
        if (num.length < 3) {
            if (num.length == 1) {
                return num[0];
            } else {
                return Math.max(num[0], num[1]);
            }
        }
        long[] nums = new long[num.length];
        for(int i = 0; i < num.length;i++){
            nums[i] = num[i];
        }
        long[] arr = new long[2];
        int l = 0;
        for (int i = 0; i < 2; i++) {
            long k = nums[0];
            for (int j = 0; j < nums.length; j++) {
                if (k < nums[j]) {
                    k = nums[j];
                }
            }
            arr[l++] = k;
            for (int m = 0; m < nums.length; m++) {
                if (nums[m] == k) {
                    nums[m] = Long.MIN_VALUE;
                }
            }
        }
        long out = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (out < nums[i]) {
                out = nums[i];
            }
        }
        return out < Integer.MIN_VALUE ? (int)arr[0] : (int)out;
    }
    @Test
    public void test(){
        int[] arr = {1,2,-2147483648};
        System.out.println(thirdMax(arr));
    }
}
