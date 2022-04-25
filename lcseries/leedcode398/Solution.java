package qrxedu.leedcode398;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public Map<Integer, List<Integer>> dict = new HashMap<>();
    public Random random = new Random();
    public Solution(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(dict.containsKey(nums[i])){
                dict.get(nums[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                dict.put(nums[i],list);
            }
        }
    }

    public int pick(int target) {
        List<Integer> l = dict.get(target);
        int len = l.size();
        return l.get(random.nextInt(len-1));
    }
}
