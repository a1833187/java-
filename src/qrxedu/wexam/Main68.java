package qrxedu.wexam;

import java.util.Scanner;

/**
 * 两个字符串之间的字典序 ab~ce 和两个数字之间的字典序一样.
 * @author qiu
 * @version 1.8.0
 */
public class Main68 {
    static int MOD = 1000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s1 = scanner.next();
            String s2 = scanner.next();
            int len1 = scanner.nextInt();
            int len2 = scanner.nextInt();
            int[] f = new int[len2+1];
            int k = 0;
            while(s1.charAt(k) == s2.charAt(k)){
                k++;
            }
            //f[i]:长度为i的合法字符串的个数
            //f[i] = f[i-1]*26 + buf
            //buf就是加上第一项中缺失的个数以及减去最后一项中多算了的个数
            //c-a = 2,指的是b和c,不包括a
            f[k+1] = s1.charAt(k) - s2.charAt(k);
            for(int i = k + 2; i <= len2; i++){
                int buf = 0;
                //加上第一项中没有计算的个数
                if(i <= s1.length()){
                    buf += 'z' - s1.charAt(i-1);
                }
                //如果小于,则减去最后一项中多计算的s2[i+1]~z
                if(i < s2.length()){
                    buf -= 'z' - s2.charAt(i-1);
                }
                //如果等于,则减去最后一项中多计算的s2[i]~z
                if(i == s2.length()){
                    buf -= 'z' - s2.charAt(i-1) + 1;
                }
                f[i] = f[i-1]*26%MOD + buf;
            }
            long res = 0;
            for(int i = len1; i <= len2; i++){
                res += f[i];
                res %= MOD;
            }
            System.out.println(res);
        }
    }
}
