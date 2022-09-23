package qrxedu.demo2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n+1];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[1] = 0;
        for(int i = 1; i <= n; i++){
            if(arr[i] != Integer.MAX_VALUE){
                for(int j = 1; j <= m; j++){
                    if(i+j <= n){
                        arr[i+j] = Math.min(arr[i+j],arr[i] + g(i,j));
                    }
                }
            }
        }
        System.out.println(arr[n]);

    }
    public static int g(int n1,int n2){
        int min = Math.min(n1,n2);
        int max = Math.max(n1,n2);
        int r = max % min;
        while(r != 0){
            max = min;
            min = r;
            r = max % min;
        }
        return min;
    }
}
