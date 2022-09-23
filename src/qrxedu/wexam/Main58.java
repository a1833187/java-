package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main58 {
    static long[] f = new long[91];
    static{
        f[1] = 1;
        f[2] = 2;
        for(int i = 3; i <= 90; i++){
            f[i] = f[i-1] + f[i-2];
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println(f[n]);
        }

    }
}
