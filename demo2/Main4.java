package qrxedu.demo2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int[] f = new int[n];
        Arrays.fill(f,1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] <= arr[j]){
                    f[i] = Math.max(f[i],f[j]+1);
                }
            }
        }
        int res = f[0];
        for(int i = 1; i < n; i++){
            res = Math.max(res,f[i]);
        }
        System.out.println(res);

    }
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        boolean[] isVisited = new boolean[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int l = 0, r = 1;
        int cnt = 0;
        while(l < n){
            isVisited[l] = true;
            while(r < n && arr[r] > arr[l] && !isVisited[r]){
                isVisited[r] = true;
                r++;
            }
            cnt++;
            while(l < n && isVisited[l]){
                l++;
            }
            r = l + 1;
        }
        System.out.println(cnt);
    }
}
