package qrxedu.lcseries.leedcode983;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        n = days[n-1];
        int[] f = new int[n+1];
        for(int i = 0,start = days[0];start <= n; start++){
            if(start == days[i]){
                    f[start] = Math.min(Integer.MAX_VALUE,f[Math.max(start - 1, 0)]+costs[0]);

                    f[start] = Math.min(f[start],f[Math.max(start - 7, 0)]+costs[1]);
                    f[start] = Math.min(f[start],f[Math.max(start - 30, 0)]+costs[2]);
                i++;
            }else{
                f[start] = f[start-1];
            }
        }
        return f[n];
    }
    @Test
    public void show(){
        //[6,8,9,18,20,21,23,25]
        //[2,10,41]
        int[] days = {6,8,9,18,20,21,23,25};
        int[] costs = {2,10,41};
        System.out.println(mincostTickets(days,costs));
    }
}
