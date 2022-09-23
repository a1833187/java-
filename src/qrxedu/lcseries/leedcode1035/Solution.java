package qrxedu.lcseries.leedcode1035;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] f = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                int num1 = nums1[i-1];
                int num2 = nums2[j-1];
                if(num1 == num2){
                    f[i][j] = f[i-1][j-1]+1;
                }else{
                    f[i][j] = Math.max(f[i][j-1],f[i-1][j]);
                }
            }
        }
        return f[m][n];
    }
}
