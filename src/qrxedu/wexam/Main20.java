package qrxedu.wexam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<String> list = new ArrayList<>();
        int left = 0, right = 0;
        while(right < str.length()){
            while(right < str.length() && str.charAt(right) != ' '){
                if(str.charAt(left) == '"'){
                    right++;
                    while(right < str.length() && str.charAt(right) != '"'){
                        right++;
                    }
                    list.add(str.substring(left+1,right));
                    right += 2;
                    left = right;
                }else{
                    right++;
                }
            }
            if(right > str.length()){
                break;
            }
            list.add(str.substring(left,right));
            left = ++right;
        }
        System.out.println(list.size());
        for(String s: list){
            System.out.println(s);
        }
    }
}
