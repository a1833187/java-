package qrxedu.wexam;

import java.util.Scanner;

/**
 * 杨辉三角的变形:求第n行的第一个偶数的位置
 * 找规律
 * @author qiu
 * @version 1.8.0
 */
public class Main28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n == 1 || n == 2){
            System.out.println(-1);
            return;
        }
        if(n % 2 != 0){
            System.out.println(2);
            return;
        }
        if(n % 4 == 0){
            System.out.println(3);
        }else{
            System.out.println(4);
        }
    }
}
