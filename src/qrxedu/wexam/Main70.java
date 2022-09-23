package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main70 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] f = new int[n];
            for(int i = 0; i < n; i++){
                f[i] = scanner.nextInt();
            }
            int[] g = new int[n];
            g[0] = f[0];
            int len = 1;
            for(int i = 1; i < n; i++){
                if(f[i] > g[len-1]){
                    g[len++] = f[i];
                }else{
                    int l = 0, r = len - 1;
                    //找已有序列中最后一个比f[i]小的元素
                    while(l < r){
                        int mid = l + r + 1 >> 1;
                        if(g[mid] <= f[i]){
                            l = mid;
                        }else{
                            r = mid - 1;
                        }
                    }
                    //可能出现元素相等,或者已有序列中的元素均比f[i]大的情况
                    //1. 1 3 4 9   f[i] == 3
                    //2. 2 4 5 7   f[i] == 1
                    if(g[r] >= f[i]){
                        g[r] = f[i];
                    }else{
                        g[r+1] = f[i];
                    }
                }
            }
            System.out.println(len);
        }
    }
}
