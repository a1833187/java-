package qrxedu.wexam;

import java.util.Scanner;

/**
 * 有障碍的只能往右和往下走的路径问题求概率.
 * 不能用路径数量/总的路径数量.因为每个点到每个点的概率是不一样的:对于第n行或第m列的点而言,其只能往右走或往下走.
 * 而对于其他的点而言,其既可以往下走也可以往右走.
 * f[n][j] = f[n][j-1] + 0.5 * f[n-1][j]
 * f[i][m] = f[i-1][m] + 0.5 * f[i][m-1]
 * f[n][m] = f[n-1][m] + f[n][m-1]
 * 所以需要直接用概率去做.
 * @author qiu
 * @version 1.8.0
 */
public class Main66 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] map = new int[n + 1][m + 1];
            double[][] f = new double[n + 1][m + 1];
            for (int i = 0; i < k; i++) {
                int r = scanner.nextInt();
                int c = scanner.nextInt();
                map[r][c] = 1;
            }
            f[1][1] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (map[i][j] == 1 || (i == 1 && j == 1)) {
                        continue;
                    }
                    f[i][j] = (i == n ? 1 : 0.5) * f[i][j-1] +
                            (j == m ? 1 : 0.5) * f[i-1][j];
                }
            }
            System.out.printf("%.2f\n", f[n][m]);
        }
    }
}
