package qrxedu.e101;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E71 {
    public int LIS (int[] arr) {
        // write code here
        int n = arr.length;
        if(n == 0){
            return 0;
        }
        int[] f = new int[n];
        Arrays.fill(f,1);
        int ans = 1;
        for(int i = 1; i < n; i++){
            for(int j = i-1; j >= 0; j--){
                if(arr[i] > arr[j]){
                    f[i] = Math.max(f[i],f[j]+1);
                }
                if(f[i] > ans){
                    ans = f[i];
                }
            }
        }
        return ans;
    }
}
