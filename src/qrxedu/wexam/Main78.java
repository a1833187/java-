package qrxedu.wexam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main78 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<String> list = new ArrayList<>();
        int l = 0,r = 0,n = str.length();
        while(l < n && !isLetter(str.charAt(l))){
            l++;
        }
        r = l;
        while(r < n){
            while(r < n && isLetter(str.charAt(r))){
                r++;
            }
            list.add(str.substring(l,r));
            while(r < n && !isLetter(str.charAt(r))){
                r++;
            }
            l = r;
        }
        n = list.size();
        for(int i = n-1; i >= 0; i--){
            if(i != 0){
                System.out.print(list.get(i) + " ");
            }else{
                System.out.print(list.get(i));
            }
        }
    }
    public static boolean isLetter(char ch){
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }
}
