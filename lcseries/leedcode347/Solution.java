package qrxedu.lcseries.leedcode347;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new TreeMap<>();
        int n = nums.length;
        for(int num :nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Map<Integer, List<Integer>> ans = new TreeMap<>();
        Set<Integer> set = map.keySet();
        for(Integer key : set){
            int val = map.get(key);
            if(ans.containsKey(val)){
                ans.get(val).add(key);
            }else{
                List<Integer>  l = new ArrayList<>();
                l.add(key);
                ans.put(val,l);
            }
        }
        List<Integer> l = new ArrayList<>();
        Set<Integer> s = ans.keySet();
        for(int key : s){
            List<Integer> cur = ans.get(key);
            for(int num : cur){
                l.add(num);
            }
        }
        int[] res = new int[k];
        int indx = 0;
        for(int i = l.size()-1; i > l.size()-1-k;i--){
            res[indx++] = l.get(i);
        }
        return res;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(solution.topKFrequent(nums, 2)));
    }
}
