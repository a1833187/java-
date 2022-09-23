package qrxedu.wexam;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main82 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] wh = new int[n][2];
        for(int i = 0; i < n; i++){
            int id = scanner.nextInt();
            wh[i][0] = scanner.nextInt();
            wh[i][1] = scanner.nextInt();
        }
        Arrays.sort(wh, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });
        int[] f = new int[n];
        Arrays.fill(f,1);
        for(int i = 1; i < n; i++){
            for(int j = i-1; j >= 0; j--){
                //if((wh[i][0] > wh[j][0] && wh[i][1] >= wh[j][1]) ||
                //(wh[i][0] == wh[j][0] && wh[i][1] == wh[j][1]))
                if(wh[i][1] >= wh[j][1]){
                    f[i] = Math.max(f[i],f[j]+1);
                }

            }
        }
        int max = 0;
        for(int num : f){
            max = Math.max(max,num);
        }

        System.out.println(max);
    }
}
