package com.qrxedu.lcseries.leedcode448;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < nums[0];i++){
            list.add(i);
        }
        for(int i = 1; i < nums.length;i++){
            if(nums[i]- nums[i-1] > 1){
                for(int j = nums[i-1] + 1; j < nums[i]; j++){
                    list.add(j);
                }
            }
        }
            for(int i = nums[nums.length-1]+1;i <=nums.length;i++){
                list.add(i);
            }
        return list;
    }
}
