package qrxedu.wexam;

import java.util.Scanner;


/**
 * @author qiu
 * @version 1.8.0
 */
public class Main16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder s = new StringBuilder();
        while(n != 0){
            s.append(n & 1);
            n = n >> 1;
        }
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                ans = 1;
                break;
            }
        }
        for(int i = 0; i < s.length()-1; i++){
            int cnt = 1;
            if(s.charAt(i) == s.charAt(i+1) && s.charAt(i) == '1'){
                while(i < s.length()-1 && s.charAt(i) == s.charAt(i+1) && s.charAt(i) == '1'){
                    i++;
                    cnt++;
                }
            }
            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);
    }
}
