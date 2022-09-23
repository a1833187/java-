package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main52 {
    public static int[] m = new int[13];
    //nianfen:尾数2位/4+尾数2位   % 7
    //runnian 1yuebian5,2yu3bian1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int year = scanner.nextInt();
            boolean flag = isRun(year);
            if(flag){
                m = new int[]{0, 5, 1, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
            }else{
                m = new int[]{0, 6, 2, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
            }
            System.out.println(year + "-01-01");
            int k = year % 100;
            int yd = (k / 4 + k) % 7;
            int md1 = (m[1] + yd + 1)%7 == 0 ? 7 : (m[1] + yd + 1)%7;
            int md2 = (m[2] + yd + 1)%7 == 0 ? 7 : (m[2] + yd + 1)%7;
            int md5 = (m[5] + yd + 31)%7 == 0 ? 7 : (m[5] + yd + 31)%7;
            int md9 = (m[9] + yd + 1)%7 == 0 ? 7 : (m[9] + yd + 1)%7;
            int md11 = (m[11] + yd + 1)%7 == 0 ? 7 : (m[11] + yd + 1)%7;
            int day1 = 15 + (md1 == 1 ? 0 : 8-md1);
            System.out.println(year + "-01-" + day1);
            int day2 = 15 + (md2 == 1 ? 0 : 8-md2);
            System.out.println(year + "-02-" + day2);
            int day5 = 32-md5;
            System.out.println(year + "-05-" + day5);
            System.out.println(year + "-07-04");
            int day9 = 1+(md9 == 1 ? 0 : 8-md9);
            System.out.println(year + "-09-0" +day9);
            int day11 = 22 + (md11 <= 4 ? 4-md11 : 11-md11);
            System.out.println(year + "-11-" + day11);
            System.out.println(year + "-12-25");
            System.out.println();
        }
    }
    public static boolean isRun(int year){
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
