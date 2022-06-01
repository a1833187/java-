package qrxedu.leedcode473;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean makesquare(int[] matchsticks) {
       int sum = 0;
       int n = matchsticks.length;
       for(int num : matchsticks){
           sum += num;
       }
       if(sum % 4 != 0){
           return false;
       }
       int len = sum / 4;
       int[] f = new int[1<<n];
       Arrays.fill(f,-1);
       f[0] = 0;
       for(int i = 1; i < 1 << n; i++){
           for(int k = 0; k < n; k++){
               int num = matchsticks[k];
               if(((i >> k) & 1) == 0){
                   continue;
               }
               int curI = i & ~(1<<k);
               if(f[curI] >= 0 && num + f[curI] <= len){
                   f[i] = (f[curI] + num) % len;
                   break;
               }
           }
       }
       return f[(1<<n)-1] == 0;
    }

}
