package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        int n = a * b;
        int r = max % min;
        while(r != 0){
            max = min;
            min = r;
            r = max % min;
        }
        System.out.println(n / min);
    }
}
