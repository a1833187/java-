package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int n1 = 0;
        int n2 = 1;
        int n3 = 1;
        while(n3 <= n){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        int res = Math.min(n3-n,n-n1);
        System.out.println(res);
    }
}
