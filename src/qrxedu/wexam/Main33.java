package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] arr = s.toCharArray();
        int l = 0,r = arr.length-1;
        while(l < r){
            char tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            l++;
            r--;
        }
        System.out.println(new String(arr));
    }
}
