package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int c = scanner.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = scanner.nextInt();
                if(c >= arr[i]){
                    c+=arr[i];
                }else{
                    c+=gcd(c,arr[i]);
                }
            }
            System.out.println(c);
        }
    }
    public static int gcd(int c,int x){
        int r = x % c;
        while(r != 0){
            x = c;
            c = r;
            r = x % c;
        }
        return c;
    }
}
