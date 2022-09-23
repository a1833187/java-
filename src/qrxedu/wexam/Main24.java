package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int cnt = 0;
            while(n != 0){
                if((n&1)==1){
                    cnt++;
                }
                n >>= 1;
            }
            System.out.println(cnt);
        }
    }
}
