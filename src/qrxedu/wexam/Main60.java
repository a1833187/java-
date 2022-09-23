package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main60 {
    static long[] fj = new long[21];
    static long[] fz = new long[21];
    static{
        fz[1] = 0;
        fz[2] = 1;
        fj[1] = 1;
        fj[2] = 2;
        for(int i = 3; i <= 20; i++){
            fj[i] = i * fj[i-1];
            //错排算法:对于n个元素,摆放的方案数为fz[n];
            /*
            第1个元素能够摆放的位置有(n-1)种,假设放在k位上.
            对于第k位而言,分两种情况讨论:
            1.放在1位上,这时剩余n-2个元素的摆放就相当于fz[n-2]
            2.不放在1位上.此时对于2~n这n-1个元素而言,摆放的方案数等价于fz[n-1]
            原因是对于第k位而言,其对应的位置被占据.而且不能摆放在1位上.所以可以等价把1位上的空位置
            放在k位上.
            1 2 3 4 5             2 3 4 5                                 2 3 4 5
                     -->(1占2位)           -->(此时1位置可以等价放在2的正下方)
            1 2 3 4 5           1   3 4 5                                 1 3 4 5
             */
            fz[i] = (i-1)*fj[i-1] + (i-1)*fz[i-2];
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            long f1 = fz[n];
            long f2 = fj[n];
            double ans = f1 * 1.0 / f2;
            System.out.printf("%.2f",ans*100);
            System.out.println("%");
        }
    }
}
