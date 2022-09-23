package qrxedu.heap;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str =  scanner.nextLine();
        char[] sb = str.toCharArray();
        int start = 0,end = 0;
        for(int i = 0; i < str.length();i++){
            if(sb[i] == ' '){
                end = i-1;
                reverse(sb,start,end);
                i++;
                start = i;
            }
        }
        reverse(sb,start,sb.length-1);
        reverse(sb,0,sb.length-1);
        System.out.println(new String(sb));
    }
    public static void reverse(char[] sb,int start,int end){
        while(start < end){
            char ch = sb[start];
            sb[start] = sb[end];
            sb[end] = ch;
            start++;
            end--;
        }
    }
}
