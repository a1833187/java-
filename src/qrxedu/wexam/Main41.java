package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main41 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next();
            while(s.length()!=1){
                int ans = 0;
                for(int i = 0; i < s.length();i++){
                    ans += (int)(s.charAt(i)-'0');
                }
                s = (String.valueOf(ans));
            }
            System.out.println(Integer.parseInt(s));
        }
    }
}
