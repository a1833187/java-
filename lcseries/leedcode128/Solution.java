package qrxedu.lcseries.leedcode128;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int ans = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int curNum = num;
                int curAns = 1;
                while(set.contains(curNum+1)){
                    curNum++;
                    curAns++;
                }
                ans = Math.max(ans,curAns);
            }
        }
        return ans;
    }
}
