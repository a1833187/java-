package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main44 {
    public static void main1(String[] args) {
        System.out.println(~-2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int a = num1 & num2;
        int b = num1 ^ num2;
        while(a != 0){
            a = a & b;
            b = a ^ b;
        }
        System.out.println(b);
    }
}
