package qrxedu.algorithm.day14.one;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int numDistinct(String s,String t){
        int m = s.length();
        int n = t.length();
        int[][] nums = new int[m+1][n+1];
        for(int i = 0; i <= n; i++){
            nums[0][i] = 0;
        }
        for(int i = 0; i <= m; i++){
            nums[i][0] = 1;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i) == t.charAt(j)){
                    nums[i][j] = nums[i-1][j] + nums[i-1][j-1];
                }else{
                    nums[i][j] = nums[i-1][j];
                }
            }
        }
        return nums[m][n];
    }
}
