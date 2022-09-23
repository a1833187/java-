package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] f = new int[n+1];
        f[1] = 1;
        f[2] = 0;
        for(int i = 3; i <= n; i++){
            for(int j = i-2; j >= 1; j--){
                f[i] += f[j];
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i++){
            ans+=f[i];
        }
        System.out.println(ans);
    }
}
