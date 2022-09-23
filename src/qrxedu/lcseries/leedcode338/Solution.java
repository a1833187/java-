package qrxedu.lcseries.leedcode338;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] countBits(int n) {
        int[] f = new int[n+1];
        for(int i = 1; i <= n; i++){
            f[i] = f[i>>1] + (i%2==0 ? 0 : 1);
        }
        return f;
    }

    @Test
    public void show(){
        System.out.println(Arrays.toString(countBits(5)));
    }
}
