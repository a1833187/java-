package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for(int i = 2; i <= n; i++){
            if(i == getNum(i)){
                System.out.println(i);
                sum++;
            }
        }
        System.out.println(sum);
    }
    public static int getNum(int n){
        int sum = 1;
        for(int i = 2; i *i <= n;i++){
            if(i * i == n){
                sum += i;
            }else if(n % i == 0){
                sum += i;
                sum += n/i;
            }
        }
        return sum;
    }
}
