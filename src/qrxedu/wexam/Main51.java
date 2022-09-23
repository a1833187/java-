package qrxedu.wexam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main51 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            int cur = n;
            for(int i = 2; i * i <= n; i++){
                if(n % i == 0){
                    while(n % i == 0){
                        list.add(i);
                        n/= i;
                    }
                }
            }
            if(n != 1){
                list.add(n);
            }
            System.out.print(cur + " =");
            int len = list.size();
            for(int i = 0; i < len; i++){
                if(i == len-1){
                    System.out.print(" " + list.get(i));
                }else{
                    System.out.print(" " + list.get(i) + " *");
                }
            }
            System.out.println();
        }
    }
}
