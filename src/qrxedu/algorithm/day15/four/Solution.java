package qrxedu.algorithm.day15.four;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 找零钱：贪心面值从大到小
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public static int minNumber(int[][] money,int sum){
        Arrays.sort(money, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        int count = 0;
        for(int[] arr: money){
            //这种处理钱的方式非常秀，k = k - k/a*a能得出k在不小于0的情况最多能减去的a的个数。
            int k = sum / arr[0];
            k = Math.min(k,arr[1]);
            sum -= k * arr[0];
            count += k;
            if(sum == 0){
                break;
            }
        }
        if(sum > 0){
            return -1;
        }
        return count;
    }
}
