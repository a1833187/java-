package qrxedu.lcseries.leedcode1751;

import java.util.Arrays;
import java.util.Comparator;

/**
 * f[i][j]表示前i个事件中挑出不超过j个事件的最大价值和
 * f[i][j] = max(f[i-1][j],f[last][j-1]+v) 分别代表不选择第i个事件和选择第i个事件
 * 当选择第i个事件时,需要从后往前挑出最接近i的一个事件last且last的结束时间要小于第i个事件的开始时间.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int n = events.length;
        int[][] f = new int[n+1][k+1];
        for(int i = 1; i <= n; i++) {
            int[] cur = events[i - 1];
            int s = cur[0], e = cur[1], v = cur[2];
            int last = 0;
            for (int j = i - 1; j >= 1; j--) {
                int[] curr = events[j - 1];
                if (curr[1] < s) {
                    last = j;
                    break;
                }
            }
            for (int l = 1; l <= k; l++) {
                f[i][l] = Math.max(f[i - 1][l], f[last][l - 1] + v);
            }
        }
        return f[n][k];
    }
}
