package qrxedu.algorithm.day16;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 安排活动：在一天中尽可能安排更多的活动
 * 每个活动都有开始时间和结束时间。每次挑选结束时间最早的活动(这样选择的一个隐含优势是该活动的开始时间也比较早)
 * 这样每次可以得到一个局部最优解。(贪心贪心)
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int getMaxNum(int[][] events){
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int sum = 0;
        for(int i = 0; i < events.length; i++){
            while(i!=0 && i < events.length && events[i][0] < events[i-1][1]){
                i++;
            }
            sum++;
        }
        return sum;
    }
}
