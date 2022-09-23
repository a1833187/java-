package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            StringBuilder s = new StringBuilder();
            int n = str.length();
            for(int i = 0; i < n; i++){
                char ch = str.charAt(i);
                if(ch >= 'A' && ch <= 'Z'){
                    s.append((char)(65+(ch-65-5+26)%26));
                }else{
                    s.append(ch);
                }
            }
            System.out.println(new String(s));
        }
    }
}
