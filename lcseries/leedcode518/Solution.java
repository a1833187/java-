package qrxedu.leedcode518;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] f = new int[n+1][amount+1];
      /*  for(int i = 0; i < n; i++){
            Arrays.fill(f[i],Integer.MIN_VALUE);
        }*/
        for(int i = 0; i <= n; i++){
            f[i][0] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                int num = coins[i-1];
                if(num > j){
                    f[i][j] = f[i-1][j];
                }else{
                    f[i][j] = f[i-1][j] +f[i][j-num];
                }
            }
        }
        if(f[n][amount] >= 0){
            return f[n][amount];
        }else{
            return 0;
        }
    }
    @Test
    public void show(){
        int[] arr = {1,2,5};
        System.out.println(4%2);
    }
}
