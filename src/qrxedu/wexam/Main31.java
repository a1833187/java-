package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while((n = scanner.nextInt()) != 0){
            int cnt = 0;
            while(n >= 3){
                cnt += n/3;
                n = n/3 + n%3;
            }
            if(n == 2){
                cnt+=1;
            }
            System.out.println(cnt);
        }
    }
}
