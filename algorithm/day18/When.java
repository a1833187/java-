package qrxedu.algorithm.day18;

import java.util.Scanner;

/**
 * 闰年：整除400 或者（整除4但不整除100）
 * @author qiu
 * @version 1.8.0
 */
public class When {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,10));
        int flag = 0;
        if(year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)){
            flag = 1;
        }
        int res = 0;
        int[] m = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i = 1 ; i < month; i++){
            res+=m[i];
        }
        if(month > 2 && flag == 1){
            res += flag;
        }
        System.out.println(res + day);
    }
}
