package qrxedu.leedcode516;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n == 1){
            return 1;
        }
        int[][] f = new int[n][n];
        for(int i = n-1;i>=0;i--){
            for(int j = i; j < n; j++){
                if(i == j){
                    f[i][j] = 1;
                }else{
                    char c1 = s.charAt(i);
                    char c2 = s.charAt(j);
                    if(j-i== 1){
                        f[i][j] = c1 == c2 ? 2 : 1;
                    }else{
                        if(c1 == c2){
                            f[i][j] = f[i+1][j-1]+2;
                        }else{
                            f[i][j] = Math.max(f[i+1][j],f[i][j-1]);
                        }
                    }
                }
            }
        }
        return f[0][n-1];
    }
    public String reverse(char[] strs){
        int l = 0,r = strs.length-1;
        while(l < r){
            char tmp = strs[l];
            strs[l] = strs[r];
            strs[r] = tmp;
            l++;
            r--;
        }
        return new String(strs);
    }
}
