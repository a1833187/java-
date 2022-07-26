package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E70 {

    public int minMoney (int[] arr, int aim) {
        // write code here
        int n = arr.length;
        int[] f = new int[aim+1];
        Arrays.fill(f,Integer.MAX_VALUE);
        f[0] = 0;
        for(int i = 0; i < n; i++){
            int num = arr[i];
            for(int j = arr[i]; j <= aim; j++){
                if(f[j-num] != Integer.MAX_VALUE) {
                    f[j] = Math.min(f[j], f[j - num] + 1);
                }
            }
        }
        if(f[aim] == Integer.MAX_VALUE){
            return -1;
        }else{
            return f[aim];
        }
    }
    @Test
    public void show(){
        int[] arr = {5,2,3};
        System.out.println(minMoney(arr,20));
    }
}
