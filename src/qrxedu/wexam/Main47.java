package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main47 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            if(n == 0){
                break;
            }
            int k = 1;
            if(n == 1){
                System.out.println(0);
            }else if(n == 2 || n == 3){
                System.out.println(1);
            }else{
                while(n > 3){
                    if(n % 3 == 0){
                        n /= 3;
                    }else{
                        n = n/3+1;
                    }
                    k++;
                }
            }
            System.out.println(k);
        }
    }
}
