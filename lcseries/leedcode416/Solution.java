package qrxedu.leedcode416;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum%2!=0){
            return false;
        }
        int m = nums.length;
        int n = sum/2;
        boolean[][] f = new boolean[m+1][n+1];
        for(int i = 0; i <= m; i++){
            f[i][0] = true;
        }
        for(int i = 1; i <= m; i++){
            for(int j =1; j <= n; j++){
                int num = nums[i-1];
                if(num > j){
                    f[i][j] = f[i][j] || f[i-1][j];
                }else{
                    f[i][j] = f[i][j] || f[i-1][j] || f[i-1][j-num];
                }
            }
        }
        return f[m][n];
    }
}
