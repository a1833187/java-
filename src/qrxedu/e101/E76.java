package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E76 {
    public boolean match (String str, String pattern) {
        // write code here
        int n1 = str.length();
        int n2 = pattern.length();
        boolean[][] f = new boolean[n1+1][n2+1];
        f[0][0] = true;
        f[0][1] = pattern.charAt(0) == '*';
        for(int i = 2; i <= n2; i++){
            char ch = pattern.charAt(i-1);
            if(ch == '*'){
                f[0][i] = f[0][i-2];
            }
        }
        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                char c1 = str.charAt(i-1);
                char c2 = pattern.charAt(j-1);
                if(isV(c1,c2)){
                    f[i][j] |= f[i-1][j-1];
                }else if(c2 == '*'){
                    f[i][j] |= f[i][j-2];
                    if(isV(c1,pattern.charAt(j-2))){
                        f[i][j] |= f[i-1][j];
                    }
                }
            }
        }
        return f[n1][n2];
    }
    public boolean isV(char c1,char c2){
        return c2 == '.' || c1 == c2;
    }
}
