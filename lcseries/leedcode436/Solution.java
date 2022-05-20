package qrxedu.leedcode436;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] first = new int[n][2];
        for(int i = 0; i < n; i++){
            first[i][0] = intervals[i][0];
            first[i][1] = i;
        }
        int[] ans = new int[n];
        Arrays.sort(first, (o1, o2) -> o1[0] - o2[0]);
        for(int i = 0; i < n; i++){
            int l = 0, r = n - 1;
            while(l < r){
                int mid = l + r >> 1;
                if(first[mid][0] >= intervals[i][1]){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            ans[i] = first[l][0] >= intervals[i][1] ? first[l][1] : -1;
        }
        return ans;
    }
}
