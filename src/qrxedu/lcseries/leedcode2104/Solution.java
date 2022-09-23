package qrxedu.lcseries.leedcode2104;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n][n];
        int[][] g = new int[n][n];
        long ans = 0;
        f[0][0] = nums[0];
        g[0][0] = nums[0];
        for(int i = 1; i < n; i++){
            for(int j = i; j < n; j++){
                if(i == j){
                    f[i][j] = nums[i];
                    g[i][j] = nums[i];
                }else{
                    f[i][j] = Math.max(nums[j],f[i][j-1]);
                    g[i][j] = Math.min(nums[j],g[i][j-1]);
                    ans += f[i][j] - g[i][j];
                }
            }
        }
        return ans;
    }
}
