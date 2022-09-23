package qrxedu.lcseries.leedcode494;

import org.junit.jupiter.api.Test;

/**
 * 一维的记忆化搜索其实 直接用dp就好(更容易操作且更容易理解)
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num: nums){
            sum+=num;
        }
        if(sum < target || -sum>target){
            return 0;
        }
        int m = nums.length;
        int[][] f = new int[m+1][2*sum+1];
        f[0][sum] = 1;
        for(int i = 1; i < f.length; i++){
            for(int j = -sum; j <= sum;j++){
                int index1 = j - nums[i-1] + sum;
                int index2 = j + nums[i-1] + sum;
                if(index1 >= 0 && index1 < f[0].length && j+sum < f[0].length){
                    f[i][j+sum] += f[i-1][index1];
                }
                if(index2 >= 0 && index2 < f[0].length){
                    f[i][j+sum] += f[i-1][index2];
                }
            }
        }
        return f[m][target+sum];
    }
    @Test
    public void show(){
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }
}
