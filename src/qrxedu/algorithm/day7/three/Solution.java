package qrxedu.algorithm.day7.three;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findGreatestSumOfSubArray(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        //这里的空间复杂度可以优化：换成total如果小于0就更新，否则加上i下标的值。
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            dp[i] = Math.max(dp[i-1] + array[i],array[i]);
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
}
