package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main12 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int m = scanner.nextInt();
       int n = scanner.nextInt();
       int[][] f = new int[m+1][n+1];
       for(int i = 0; i <= m; i++){
           f[i][0] = 1;
       }
       for(int i = 0; i <= n; i++){
           f[0][i] = 1;
       }
       for(int i = 1; i <= m; i++){
           for(int j = 1; j <= n; j++){
               f[i][j] = f[i-1][j] + f[i][j-1];
           }
       }
        System.out.println(f[m][n]);
    }
}
