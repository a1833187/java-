package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[m][n];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 0){
                    arr[i][j] = 1;
                    res++;
                    if(i+2<m){
                        arr[i+2][j] = 1;
                    }
                    if(j+2<n){
                        arr[i][j+2] = 1;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
