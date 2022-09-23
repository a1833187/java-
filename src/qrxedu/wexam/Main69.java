package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main69 {
    static long[] f = new long[21];
    static{
        f[2] = 1;
        for(int i = 3; i <= 20; i++){
            f[i] = (f[i-1] + f[i-2])*(i-1);
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
