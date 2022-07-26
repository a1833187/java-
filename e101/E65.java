package qrxedu.e101;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E65 {
    public String LCS (String s1, String s2) {
        // write code here
        int m = s1.length();
        int n = s2.length();
        int[][] f = new int[m+1][n+1];
        String[][] s = new String[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char c1 = s1.charAt(i-1);
                char c2 = s2.charAt(j-1);
                if(c1 == c2){
                    f[i][j] = f[i-1][j-1] + 1;
                    s[i][j] = "TL";
                }else if(f[i-1][j] > f[i][j-1]){
                    f[i][j] = f[i-1][j];
                    s[i][j] = "T";
                }else{
                    f[i][j] = f[i][j-1];
                    s[i][j] = "L";
                }
            }
        }
        if(f[m][n] == 0){
            return "-1";
        }
        StringBuilder ans = new StringBuilder();
        int i = m;
        int j = n;
        int t = f[m][n];
        while(i >= 1 && j >= 1){
            if("TL".equals(s[i][j])){
                ans.insert(0,s1.charAt(i-1));
                i--;
                j--;
            }else if("T".equals(s[i][j])){
                i--;
            }else{
                j--;
            }
        }
        return new String(ans);
    }
    @Test
    public void show(){
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23A456A";
        System.out.println(LCS(s1,s2));
    }
}
