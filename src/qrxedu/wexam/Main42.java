package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main42 {
    static int[][] dict = new int[10001][2];
    static boolean flag = false;
    public static void main(String[] args) {
       if(!flag){
           dict[1][0] = 1;
           dict[1][1] = 1;
           for(int i = 2; i <= 10000; i++){
               dict[i][0] = (dict[i-1][0]+dict[i-1][1])%10000;
               dict[i][1] = dict[i-1][0];
           }
           flag = true;
       }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = scanner.nextInt();
            }
            for(int i = 0; i < n; i++){
                String ans = getName(dict[arr[i]][0]);
                if(i != n-1){
                    System.out.println(ans + " ");
                }else{
                    System.out.println(ans);
                }
            }

        }
    }
    public static String getName(int n){
       StringBuilder s = new StringBuilder(String.valueOf(n));
        while(s.length() < 4){
            s.insert(0,'0');
        }
        return s.substring(s.length() - 4, s.length());
    }
}
