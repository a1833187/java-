package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E75 {
    public int editDistance (String str1, String str2) {
        // write code here
        int n1 = str1.length();
        int n2 = str2.length();
        int[][] f = new int[n1+1][n2+1];
        for(int i = 1; i <= n1; i++){
            f[i][0] = i;
        }
        for(int i = 1; i <= n2; i++){
            f[0][i] = i;
        }
        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                char c1 = str1.charAt(i-1);
                char c2 = str2.charAt(j-1);
                if(c1 == c2){
                    f[i][j] = f[i-1][j-1];
                }else{
                    f[i][j] = Math.min(f[i-1][j-1],Math.min(f[i-1][j],f[i][j-1]))+1;
                }
            }
        }
        return f[n1][n2];
    }
}
