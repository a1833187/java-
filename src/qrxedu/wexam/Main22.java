package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main22 {
    static int[] m = {0,31,59,90,120,151,181,212,243,273,304,334,365};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        boolean flag = false;
        if(year % 400 == 0 ||(year % 4 == 0 && year % 100 != 0)){
            flag = true;
        }
        int ans = 0;
        if(month <= 2){
            ans = m[month-1] + day;
        }else{
            if(flag){
                ans = m[month-1]+day+1;
            }else{
                ans = m[month-1] + day;
            }
        }
        System.out.println(ans);
    }
}
