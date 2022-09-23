package qrxedu.lcseries.leedcode664;

/**
 * 奇怪的打印机:
 * f[i][j]:s[i]==s[j]时,优先打印,且f[i][j] = f[i][j-1]:在打印s[i]时直接覆盖到s[j]
 * s[i]!=s[j]时,f[i][j] = min(f[i][k] + f[k+1][j]),实际上最小值也是尽可能的满足s[i] == s[k]或
 * s[k+1] == s[j],但因为是无差别遍历,所以说不需要写判断条件.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for(int i = n-1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(i == j){
                    f[i][j] = 1;
                }else{
                    char c1 = s.charAt(i);
                    char c2 = s.charAt(j);
                    if(c1 == c2){
                        f[i][j] = f[i][j-1];
                    }else{
                        f[i][j] = Integer.MAX_VALUE;
                        for(int k = i;k < j;k++){
                            f[i][j] = Math.min(f[i][j],f[i][k]+f[k+1][j]);
                        }
                    }
                }
            }
        }
        return f[0][n-1];
    }
}
