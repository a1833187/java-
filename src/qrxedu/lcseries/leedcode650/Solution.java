package qrxedu.lcseries.leedcode650;

import java.util.Arrays;

/**
 * cv工程师
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    public int minSteps(int n) {
        int[] f = new int[n+1];
        Arrays.fill(f,Integer.MAX_VALUE);
        f[1] = 0;
        for(int i = 2; i <= n; i++){
            /*for(int j = 1; j < i;j++){
                if(i%j==0){
                    f[i] = Math.min(f[i],f[j] + i/j);
                }
            } 这可以进行优化：因为要求j可以被i整除，所以在根号i内搜索即可
            */
            for(int j = 1;j * j <= i; j++){
                if(i % j == 0){
                    f[i] = Math.min(f[i],f[j] + i/j);
                    f[i] = Math.min(f[i],f[i/j] + j);
                }
            }

        }
        return f[n];
    }
}
