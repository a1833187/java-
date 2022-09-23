package qrxedu.wexam;

import java.util.Scanner;

/**
 * 正则表达式进阶版:含有不能匹配的字符.
 * @author qiu
 * @version 1.8.0
 */
public class Main30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String t1 = scanner.next();
        String s = s1.toUpperCase();
        String t = t1.toUpperCase();
        int n = s.length();
        int m = t.length();
        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        f[0][1] = (s.charAt(0) == '*');
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                char chT = t.charAt(i-1);
                char chS = s.charAt(j-1);
                if((chT == chS) || (chS == '?' && isValid(chT))){
                    f[i][j] = f[i][j] || f[i-1][j-1];
                }else if(chS == '*'){
                    f[i][j] = f[i][j]  || f[i][j-1];
                    if(isValid(chT)){
                        f[i][j] = f[i][j] || f[i-1][j];
                    }
                }
            }
        }
        System.out.println(f[m][n]);
    }
    public static boolean isValid(char ch){
        return (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <='9');
    }
}
