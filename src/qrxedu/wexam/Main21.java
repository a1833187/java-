package qrxedu.wexam;


import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] f = new int[m+1];
        Arrays.fill(f,Integer.MAX_VALUE);
        f[n] = 0;
        for(int i = n; i <= m;i++){
            if(f[i] != Integer.MAX_VALUE){
                TreeSet<Integer> set = getY(i);
                for(int k : set) {
                    if (i + k <= m) {
                        f[i + k] = Math.min(f[i + k], f[i] + 1);
                    }
                }
            }
        }
        if(f[m] == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(f[m]);
        }
    }

    public static TreeSet<Integer> getY(int n) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                set.add(i);
                if (n / i != i) {
                    set.add(n / i);
                }
            }
        }
        return set;
    }
}
