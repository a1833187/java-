package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E53 {
    public int minNumberDisappeared1(int[] nums){
        //原地哈希
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] <= 0){
                nums[i] = Math.abs(nums[i]) + 1;
            }
        }
        for(int i = 0; i < n; i++){
            if(Math.abs(nums[i]) <= n){
                nums[Math.abs(nums[i])-1] = -1 * Math.abs( nums[Math.abs(nums[i])-1] );
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n+1;
    }
    public int minNumberDisappeared (int[] nums) {
        // write code here
        Arrays.sort(nums);
        int n = nums.length;
        int be = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < n-1; i++){
            if(nums[i] <= 0){
                continue;
            }
            if(be > nums[i]){
                be = nums[i];
            }
            if(nums[i] == nums[i+1]){
                continue;
            }
            if(nums[i] != nums[i+1] - 1){
                ans = nums[i] + 1;
                break;
            }
        }
        if(be != Integer.MAX_VALUE && be != 1){
            return 1;
        }
        if((be == Integer.MAX_VALUE || be == 1) && ans == 0){
            return nums[n-1] + 1;
        }
        return ans;
    }

    @Test
    public void show(){
        int[] arr = {7,8,9,11,12};
        System.out.println(minNumberDisappeared(arr));
    }
}
