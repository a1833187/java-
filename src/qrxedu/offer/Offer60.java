package qrxedu.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer60 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for(int l = 1,r = 2; l < r;){
            int sum = (l + r) * (r - l + 1) / 2;
            if(sum == target){
                int[] cur = new int[r - l + 1];
                for(int i = l;i <= r; i++){
                    cur[i-l] = i;
                }
                list.add(cur);
                l++;
            }else if(sum < target){
                r++;
            }else{
                l++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
