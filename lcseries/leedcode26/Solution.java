package com.qrxedu.leedcode26;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int res = nums.length;
        if(res == 0 || res == 1){
            return res;
        }
        int i = 0;
        int j = 1;
        while(i < len && j < len){
            if(nums[j] == nums[i]){
                for(; j < len;j++){
                    if(nums[j] != nums[i]){
                        break;
                    }
                }
            }
            nums[i+1] = nums[j];
            res = res - (j -i - 1);
            i++;
            j++;
        }
        return res;
    }
    @Test
    public void show(){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
