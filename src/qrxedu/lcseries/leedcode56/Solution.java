package qrxedu.lcseries.leedcode56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        List<int[]> l = new ArrayList<>();
        int n = intervals.length;
        int i = 0;
        while(i < n){
            if(i+1 < n && intervals[i][1] >= intervals[i+1][0]){
                int start = intervals[i][0];
                int end = intervals[i][1];
                while(i+1 < n && end >= intervals[i+1][0]){

                    if(end < intervals[i+1][1]){
                        end = intervals[i+1][1];
                    }
                    i++;
                }
                int[] cur = new int[2];
                cur[0] = start;
                cur[1] = end;
                l.add(cur);
            }else{
                l.add(intervals[i]);
            }
            i++;
        }
        int[][] ans = new int[l.size()][2];
        i = 0;
        for(int[] cur : l){
            ans[i++] = cur;
        }
        return ans;
    }
}
