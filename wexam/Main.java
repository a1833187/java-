package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int i = 0;
        int res = 0;
        while (i < n) {
            if (i + 1 < n && arr[i] < arr[i + 1]) {
                while (i + 1 < n && arr[i] <= arr[i + 1]) {
                    i++;
                }
                res++;
            } else if(i + 1 < n && arr[i] > arr[i + 1]){
                while (i + 1 < n && arr[i] >= arr[i + 1]) {
                    i++;
                }
                res++;
            }else if(i + 1 < n && arr[i] == arr[i + 1]){
                while(i + 1 < n && arr[i] == arr[i + 1]){
                    i++;
                }
            }else{
                res++;
            }
            i++;
        }
        System.out.println(res);
    }
}
