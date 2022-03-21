package qrxedu.leedcode97;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 1; i <= m; i++){
            if(s1.substring(0,i).equals(s3.substring(0,i))){
                dp[i][0] = true;
            }
        }
        for(int i = 1; i <= n; i++){
            if(s2.substring(0,i).equals(s3.substring(0,i))){
                dp[0][i] = true;
            }
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s3.charAt(i+j-1)){
                    //这里必须加上dp[i][j] || 因为可能出现s3的这个字符和s1和s2的对应的那个字符都相等
                    //这样的话只需要满足其中一个即为true
                    dp[i][j] = dp[i][j] || dp[i-1][j];
                }
                if(s2.charAt(j-1) == s3.charAt(i+j-1)){
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
