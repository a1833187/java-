package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main53 {
    public static int[] cache = new int[100001];

    static {
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= 100000; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
            if (cache[i] > 1000000) {
                cache[i] = cache[i] % 1000000;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if(n < 25){
                System.out.printf("%d\n",cache[n]);
            }else{
                //因为可能出现两个6位数相加正好让最高位变成0的情况  111111+900000 = 1011111 % 1000000 = 011111
                System.out.printf("%06d\n",cache[n]);
            }
        }
    }
}
