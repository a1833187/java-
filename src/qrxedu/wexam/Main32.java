package qrxedu.wexam;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String t1 = scanner.nextLine();
        int m = s1.length();
        int n = t1.length();
        String s = m <= n ? s1 : t1;
        String t = m > n ? s1 : t1;
        int len = s.length();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < len;i++){
            for(int j = len-1; j >= i; j--){
                if(t.contains(s.substring(i,j+1))){
                    if(list.size() == 0){
                        list.add(s.substring(i,j+1));
                    }else{
                        if(j+1-i>list.get(list.size()-1).length()){
                            list.add(s.substring(i,j+1));
                        }
                    }
                    break;
                }
            }
        }
        System.out.println(list.get(list.size()-1));
    }
}
