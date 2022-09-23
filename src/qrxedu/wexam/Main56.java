package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main56 {
    static long[] f = new long[81];
    static{
        f[1] = 1;
        f[2] = 1;
        for(int i = 3; i <= 80; i++){
            f[i] = f[i-1] + f[i-2];
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            long ans = 0;
            for(int i = from; i <= to; i++){
                ans += f[i];
            }
            System.out.println(ans);
        }
    }
}
