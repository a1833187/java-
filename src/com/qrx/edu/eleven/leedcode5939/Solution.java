package com.qrx.edu.eleven.leedcode5939;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k==0){
            return nums;
        }
        int[] oi = new int[nums.length];
        if(nums.length<(2*k+1)){
            for(int i = 0; i < nums.length;i++){
                oi[i] = -1;
                return oi;
            }
        }
        int[] o = new int[nums.length];
        for(int i = 0; i < k;i++){
            o[i] = -1;
        }
        for(int i = nums.length-k;i<nums.length;i++){
            o[i] = -1;
        }
        long sum = 0;
        for(int i = 0; i < 2*k;i++){
            sum += nums[i];
        }
        for(int i = k; i < nums.length-k; i++){
            sum+=nums[k+i];
            o[i] = (int)(sum/(2*k+1));
            sum-=nums[i-k];
        }
        return o;
    }
   /* @Test
    public void show(){

    }*/

}
