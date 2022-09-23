package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main77 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            String[] strs = str.split("_");
            StringBuilder s = new StringBuilder(strs[0]);
            for(int i = 1; i < strs.length; i++){
                StringBuilder cur = new StringBuilder(strs[i]);
                char ch = cur.charAt(0);
                cur.setCharAt(0, (char) (ch-'a'+'A'));
                s.append(cur);
            }
            System.out.println(new String(s));
        }
    }
}
