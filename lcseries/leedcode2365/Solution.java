package qrxedu.lcseries.leedcode2365;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long ans = 0;
        int n = tasks.length;
        Map<Integer,Long> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(tasks[i])){
                if(map.get(tasks[i]) + space <= ans){
                    ans += 1;
                }else{
                    ans = map.get(tasks[i]) + space + 1;
                }
                map.put(tasks[i],ans);
            }else{
                ans += 1;
                map.put(tasks[i],ans);
            }
        }
        return ans;
    }
}
