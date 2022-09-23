package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main55 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String ss = scanner.nextLine();
            String[] strs = ss.split(" ");
            String s =strs[0];
            String t =strs[1];
            int m = s.length();
            int n = t.length();
            if(m < n){
                System.out.println(0);
            }else{
                int l = 0;
                int ans = 0;
                while(l < m){
                    if(l+n<=m && (s.substring(l,l+n).equals(t))){
                        ans++;
                        l = l+n;
                    }else{
                        l++;
                    }
                }
                System.out.println(ans);
            }
        }
    }
}
