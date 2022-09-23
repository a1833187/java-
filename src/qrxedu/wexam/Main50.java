package qrxedu.wexam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main50 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int k = 0;
            for(int i = 2; i * i <= n; i++){
                if(n % i == 0){
                    while(n % i == 0){
                        n/=i;
                    }
                    k++;
                }
            }
            if(n != 1){
                k++;
            }
            System.out.println(k);
        }
    }
}