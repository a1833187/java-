package qrxedu.demo2;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main3 {
    public static int[] vx;
    public static int[] wx;
    public static int cnt;
    public static int n;
    public static int v;
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        v = scanner.nextInt();
        vx = new int[n+1];
        wx = new int[n+1];
        for(int i = 1;i <= n; i++){
            vx[i] = scanner.nextInt();
            wx[i] = scanner.nextInt();
        }
        cnt = 0;
        dfs(1,0,0);
        System.out.println(cnt);
    }
    public static void dfs(int index,int sumW,int sumV){
        if(index > n){
            return;
        }
        if(sumV >= v){
            if(sumV == v){
                cnt = Math.max(cnt,sumW);
            }
            return;
        }
        for(int i = index; i <= n; i++){
            dfs(index+1,sumW+wx[i],sumV+vx[i]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int v = scanner.nextInt();
        int[] vx = new int[n+1];
        int[] wx = new int[n+1];
        for(int i = 1;i <= n; i++){
            vx[i] = scanner.nextInt();
            wx[i] = scanner.nextInt();
        }
        int[][] f = new int[n+1][v+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= v; j++){
                f[i][j] = Integer.MIN_VALUE;
            }
        }
       for(int i = 0; i <= n; i++){
           f[i][0] = 0;
       }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= v; j++){
                if(vx[i] > j){
                    f[i][j] = f[i-1][j];
                }else{
                    f[i][j] = Math.max(f[i-1][j],f[i-1][j-vx[i]]+wx[i]);
                }
                if(f[i][j] < 0){
                    f[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        if(f[n][v]>0) {
            System.out.println(f[n][v]);
        }else{
            System.out.println(0);
        }
    }
}
