package qrxedu.algorithm.day19;

import java.util.Scanner;

/**
 * f(n) = 1! * 2! * ... * n! ，求f(n)的末尾0的个数
 * @author qiu
 * @version 1.8.0
 */
public class Solution3 {
    public static int cal(int num,int k){
        int res = 0;
        while(num != 0){
            if(num % k == 0){
                res++;
            }
            num /= k;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            cnt += (cal(i,5) * (n-i+1));
        }
        System.out.println(cnt);
    }
}
