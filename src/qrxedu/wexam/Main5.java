package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int[] dp = new int[n];
        dp[0] = arr[0];
        int max = dp[0];
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(arr[i],arr[i]+dp[i-1]);
            max = Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
