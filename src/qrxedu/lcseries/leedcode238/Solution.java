package qrxedu.lcseries.leedcode238;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        int[] cn = new int[len];
        int[] bn = new int[len];
        cn[0] = nums[0];
        bn[0] = nums[len - 1];
        for (int i = 1; i < len - 1; i++) {
            cn[i] = nums[i] * cn[i - 1];
            bn[i] = nums[len - 1 - i] * bn[i - 1];
        }
        output[0] = bn[len - 2];
        output[len - 1] = cn[len - 2];
        for (int i = 1; i < len - 1; i++) {
            output[i] = cn[i - 1] * bn[len - 2 - i];
        }
        return output;
    }
    @Test
    public void show(){
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
