package qrxedu.demo2;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] price = new int[m+1][4];
        int[][] man = new int[m+1][4];
        for(int i = 0; i < m; i++){
            int v = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            price[i+1][0] = v;
            man[i+1][0] = p;
            if(q == 1){
                price[i+1][1] = scanner.nextInt()+v;
                man[i+1][1] = scanner.nextInt()+p;
            }else if(q == 2){
                int v1 = scanner.nextInt();
                int p1 = scanner.nextInt();
                int v2 = scanner.nextInt();
                int p2 = scanner.nextInt();
                price[i+1][1] = v+v1;
                price[i+1][2] = v+v2;
                price[i+1][3] = v+v1+v2;
                man[i+1][1] = p+p1;
                man[i+1][2] = p+p2;
                man[i+1][3] = p+p1+p2;
            }
        }
        int[][] f = new int[m+1][n+1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 0; k < 4; k++){
                    if(price[i][k] > j){
                        f[i][j] = Math.max(f[i][j],f[i-1][j]);
                    }else {
                        if (price[i][k] != 0) {
                            f[i][j] = Math.max(f[i][j], Math.max(f[i - 1][j], f[i - 1][j - price[i][k]] + man[i][k]));
                        }
                    }
                }
            }
        }
        System.out.println(f[m][n]);
    }
}
