package qrxedu.lcseries.leedcode78;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> l = new ArrayList<>();
        dfs(nums,l,0);
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> cur : ans){
            res.add(cur);
        }
        return res;
    }
    private void dfs(int[] nums,List<Integer> l,int index){
        if(index == nums.length){
            List<Integer> cur = new ArrayList<>();
            for(int num : l){
                cur.add(num);
            }
            ans.add(cur);
            return;
        }
        l.add(nums[index]);
        dfs(nums,l,index+1);
        l.remove(l.size()-1);
        dfs(nums,l,index+1);
    }
}
