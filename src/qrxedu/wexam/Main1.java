package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int left = 0;
        int right = 0;
        int[] max = new int[2];
        int maxL = 0;
        int i = 0;
        while(i < str.length()){
            if(str.charAt(i) >='0' && str.charAt(i) <= '9'){
                left = i;
                i++;
                while(i<str.length() && str.charAt(i) >='0' && str.charAt(i) <= '9'){
                    i++;
                }
                right = i-1;
                if(maxL < right - left + 1){
                    max[0] = left;
                    max[1] = right;
                    maxL = right-left+1;
                }
            }else{
                i++;
            }
        }
        System.out.println(str.substring(max[0],max[1]+1));
    }
}
