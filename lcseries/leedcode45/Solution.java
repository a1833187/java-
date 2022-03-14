package qrxedu.leedcode45;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int jump(int[] nums) {
        int[] f = new int[nums.length];
        Arrays.fill(f,Integer.MAX_VALUE);
        f[0] = 0;
        for(int i = 1; i < nums.length;i++){
            for(int k = 0; k < i;k++){
                if(nums[k] >= i-k){
                    f[i] = Math.min(f[i],f[k] + 1);
                }
            }
        }
        return f[nums.length-1];
    }
}
