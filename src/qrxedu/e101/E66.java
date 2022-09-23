package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E66 {
    public String LCS (String str1, String str2) {
        // write code here
        int m = str1.length();
        int n = str2.length();
        int ans = 0;
        int[][] f = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char c1 = str1.charAt(i-1);
                char c2 = str2.charAt(j-1);
                if(c1 != c2){
                    continue;
                }
                f[i][j] = f[i-1][j-1] + 1;
                if(ans < f[i][j]){
                    ans = f[i][j];
                }
            }
        }
        String s = "";
        for(int i = 1;i <= m; i++){
            for(int j = 1;j <= n; j++){
                if(f[i][j] == ans){
                    for(int k = i - ans; k < i; k++){
                        s += str1.charAt(k);
                    }
                    return s;
                }
            }
        }
        return s;
    }
}
