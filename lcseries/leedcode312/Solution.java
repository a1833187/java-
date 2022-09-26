package qrxedu.lcseries.leedcode312;

import org.junit.jupiter.api.Test;

/**
 * 想到区间dp了,但是没想到k的处理方式:k指的是i~j区间内最后一个被切割的气球坐标
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n+2][n+2];
        int[] arr = new int[n+2];
        arr[0] = arr[n+1] = 1;
        for(int i = 1; i <= n; i++){
            arr[i] = nums[i-1];
        }
        for(int len = 1; len <= n; len++){
            for(int i = 1;i + len - 1 <= n; i++){
                int j = i + len - 1;
                for(int k = i; k <= j; k++){
                    // 因为k是i~j区间内最后一个被切割的下标,所以此时k的左侧的气球为i-1,右侧为j+1
                    f[i][j] = Math.max(f[i][j],f[i][k-1]+f[k+1][j]+arr[k]*arr[i-1]*arr[j+1]);
                }
            }
        }
        return f[1][n];
    }
    @Test
    public void show(){
        int[] nums = {3,1,5,8};
        System.out.println(maxCoins(nums));
    }
}
