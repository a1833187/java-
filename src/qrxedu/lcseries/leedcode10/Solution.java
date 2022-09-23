package qrxedu.lcseries.leedcode10;

/**
 * 正则表达式匹配：
 * '.':匹配任意个字符
 * '*':匹配0个或多个前面的那一个元素，这里的匹配0个的意思是把前面那个元素删掉
 * 比如 s:abb p:c*a*b   --->true  首先第一个'*'匹配0个c，然后啊吧啊吧。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isMatch(String s,String p){
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i = 0; i <= m; i++){
            for(int j = 1; j <= n; j++){
               if(p.charAt(j-1) == '*'){
                   dp[i][j] = dp[i][j-2];
                   if(i>0&&(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.')){
                       dp[i][j] = dp[i][j] || dp[i-1][j];
                   }
               }else{
                   if(i>0&&(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.')){
                       dp[i][j] = dp[i-1][j-1];
                   }
               }
            }
        }
        return dp[m][n];
    }
}
