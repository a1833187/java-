package qrxedu.wexam;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main83 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();
            int d = scanner.nextInt();
            //这里的单位非常重要.因为50个50相乘会超过Integer的范围.
            long[][] f = new long[n+1][k+1];
            long[][] g = new long[n+1][k+1];
            long max = Integer.MIN_VALUE;
            for(int i = 1; i <= n; i++){
                f[i][1] = nums[i-1];
                g[i][1] = nums[i-1];
                for(int j = 2; j <= k; j++){
                    int l = Math.max(i-d,0);
                    for(int r = i-1; r >= l;r--){
                        f[i][j] = Math.max(Math.max(f[i][j],f[r][j-1]*nums[i-1]),g[r][j-1]*nums[i-1]);
                        g[i][j] = Math.min(Math.min(g[i][j],g[r][j-1]*nums[i-1]),f[r][j-1]*nums[i-1]);

                    }
                }
                max = Math.max(max,f[i][k]);
            }
            System.out.println(max);
        }
    }
    @Test
    public void show(){
        System.out.println((long)1e5*1e5);
    }
}
