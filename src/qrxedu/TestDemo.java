package qrxedu;

/**
 * @author qiu
 * @version 1.8.0
 */
public class TestDemo{
    static int[][] f;
    public static void main(String[] args) {
        String x = "EDABDFE";
        String y = "DEADBE";
        System.out.println(getMaxLen(x,y));
        for(int i = 0; i < f.length; i++){
            for(int j = 0; j < f[0].length; j++){
                System.out.print(f[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int getMaxLen(String s,String t){
        int m = s.length();
        int n = t.length();
        f = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char c1 = s.charAt(i-1);
                char c2 = t.charAt(j-1);
                if(c1 == c2){
                    f[i][j] = f[i-1][j-1] + 1;
                }else{
                    f[i][j] = Math.max(f[i-1][j],f[i][j-1]);
                }
            }
        }
        return f[m][n];
    }
}