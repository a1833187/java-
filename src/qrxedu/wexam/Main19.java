package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = n / 2;
        while(m != 1){
            if(isSu(m) && isSu(n-m)){
                System.out.println(m);
                System.out.println(n-m);
                return;
            }
            m--;
        }
    }
    public static boolean isSu(int n){
        if(n == 2){
            return true;
        }
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
