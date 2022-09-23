package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E82 {
    public int maxProfit (int[] prices) {
        // write code here
        int n = prices.length;
        if(n == 1){
            return 0;
        }
        int[][] f = new int[n][5];
        Arrays.fill(f[0],-10000);
        f[0][0] = 0;
        f[0][1] = -prices[0];
        for(int i = 1; i < n; i++){
            f[i][0] = f[i-1][0];
            f[i][1] = Math.max(f[i-1][1],f[i-1][0]-prices[i]);
            f[i][2] = Math.max(f[i-1][2],f[i-1][1]+prices[i]);
            f[i][3] = Math.max(f[i-1][3],f[i-1][2])-prices[i];
            f[i][4] = Math.max(f[i-1][4],f[i-1][3]+prices[i]);
        }
        return Math.max(f[n-1][2],Math.max(f[n-1][4],0));
    }
    @Test
    public void show(){
        int[] arr = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(maxProfit(arr));
    }
}
