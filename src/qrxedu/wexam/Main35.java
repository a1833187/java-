package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++){
            int n = scanner.nextInt();
            int k1 = scanner.nextInt();
            int k = k1;
            long[] arr = new long[2*n];
            for(int j = 0; j < 2*n; j++){
                arr[j] = scanner.nextLong();
            }
            for(int j = 0; j < k;j++){
                arr = swap(arr);
            }
            for(int j = 0; j < 2*n;j++){
                if(j != 2*n-1){
                    System.out.print(arr[j] + " ");
                }else{
                    System.out.println(arr[j]);
                }
            }
        }
    }
    public static long[] swap(long[] arr){
        int n = arr.length;
        long[] tmp = new long[n];
        int k = 0;
        for(int i = 0; i < n/2; i++){
            tmp[k++] = arr[i];
            tmp[k++] = arr[i+n/2];
        }
        return tmp;
    }
}
