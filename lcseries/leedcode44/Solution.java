package qrxedu.leedcode44;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        //对可能为空串的初始化.
        if(m == 0 && n == 0){
            return true;
        }
        if(m != 0 && n == 0){
            return false;
        }
        if(m == 0){
            for(int i = 0; i < n; i++){
                if(p.charAt(i) != '*'){
                    return false;
                }
            }
            return true;
        }
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        f[0][1] = p.charAt(0) == '*';
        //因为输入的s字符串可能为空,所以要对首行进行初始化.
        for(int i = 2; i <= n; i++){
            if(p.charAt(i-1) == '*'){
                f[0][i] = f[0][i] || f[0][i-1];
            }
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char chS = s.charAt(i-1);
                char chP = p.charAt(j-1);
                if(chP == '?' || chP == chS){
                    f[i][j] = f[i][j] || f[i-1][j-1];
                }else if(chP == '*'){
                    f[i][j] = f[i][j] || f[i][j-1] || f[i-1][j];
                }
            }
        }
        return f[m][n];
    }
    @Test
    public void show(){
        String s = "ho";
        String p = "**ho";
        System.out.println(isMatch(s,p));
    }
}
