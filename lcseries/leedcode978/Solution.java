package qrxedu.leedcode978;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if(n == 1){
            return 1;
        }
        int[][] f = new int[n+1][2];
        for(int i = 1; i <= n; i++){
            Arrays.fill(f[i],1);
        }
        int max = 1;
        for(int i = 2; i <= n; i++){
            int dif = arr[i-1] - arr[i-2];
            if(dif > 0){
                f[i][1] = f[i-1][0] + 1;
            }else if(dif < 0){
                f[i][0] = f[i-1][1] + 1;
            }
            max = Math.max(max,Math.max(f[i][0],f[i][1]));
        }
        return max;
    }
}
