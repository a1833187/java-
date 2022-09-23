package qrxedu.wexam;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main48 {
    public int INF = -0x3f3f3f3f;
    public int getFirstUnFormedNum(int[] arr) {
        int n = arr.length;
        int sum = arr[0];
        int min = arr[0];
        for(int i = 1; i < n; i++){
            sum+=arr[i];
            min = Math.min(min,arr[i]);
        }
        for(int k = min+1;k<sum;k++){
            int[] f = new int[k+1];
            Arrays.fill(f,INF);
            f[0] = 0;
            for(int i = 0; i < n; i++){
                int num = arr[i];
                for(int j = k; j >= arr[i];j--){
                    f[j] = Math.max(f[j],f[j-num]+num);
                    if(f[j] < 0){
                        f[j] = INF;
                    }
                }
            }
            if(f[k] == INF){
                return k;
            }
        }
        return sum+1;
    }
    @Test
    public void show(){
        int[] arr = {3,2,5};
        System.out.println(getFirstUnFormedNum(arr));
    }
}
