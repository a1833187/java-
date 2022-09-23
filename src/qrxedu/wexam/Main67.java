package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main67 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            String t = scanner.next();
            int m = s.length();
            int n = t.length();
            int[][] f = new int[m+1][n+1];
            for(int i = 1;  i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(s.charAt(i-1) == t.charAt(j-1)){
                        f[i][j] = f[i-1][j-1] + 1;
                    }else{
                        f[i][j] = Math.max(f[i-1][j],f[i][j-1]);
                    }
                }
            }
            System.out.println(f[m][n]);
        }
    }
}
