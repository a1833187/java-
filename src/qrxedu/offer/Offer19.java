package qrxedu.offer;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer19 {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            if(s == null && p == null){
                return true;
            }else{
                return false;
            }
        }
        int m = s.length();
        int n = p.length();
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for(int i = 2; i <= n; i++){
            if(p.charAt(i-1) == '*'){
                f[0][i] = f[0][i-2];
            }
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char ch1 = s.charAt(i-1);
                char ch2 = p.charAt(j-1);
                if(isV(ch1,ch2)){
                    f[i][j] = f[i-1][j-1];
                }else if(ch2 == '*'){
                    f[i][j] = f[i][j-2];
                    if(isV(ch1,p.charAt(j-2))){
                        f[i][j] |= f[i-1][j];
                    }
                }
            }
        }
        System.out.println();
        return f[m][n];
    }
    public boolean isV(char ch1,char ch2){
        return (ch1 == ch2 || ch2  == '.');
    }
    @Test
    public void show(){
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch(s,p));
    }
}
