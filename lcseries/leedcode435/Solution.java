package qrxedu.leedcode435;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 删除最小数量的区间使得所有区间都不重叠。
 * 贪心：按照每个区间的起始时间进行递增排序，当出现两个区间相互重叠时需要删除其中结束时间更晚的区间。
 * 这是因为结束时间更晚意味着和后面的区间的起始时间重叠的概率更大。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] events){
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int num = 0;
        int i = 0;
        for(int j = 1; j < events.length; j++){
            if(events[j][0] >= events[i][1]){
                i = j;
            }else{
                num++;
                 i = events[i][1] > events[j][1] ? j : i;
            }
        }
        return num;
    }
}
