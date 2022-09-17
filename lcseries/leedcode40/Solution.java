package qrxedu.lcseries.leedcode40;

import java.util.*;

/**
 * 全排列问题:回溯+剪枝(排序+去重)
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,list,target,0);
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> cur : set){
            ans.add(cur);
        }
        return ans;
    }
    private void dfs(int[] candidates,List<Integer> l,int target,int index){
        if(target <= 0){
            if(target == 0){
                List<Integer> cur = new ArrayList<>();
                for(int num : l){
                    cur.add(num);
                }
                set.add(cur);
            }
            return;
        }
        for(int i = index; i < candidates.length; i++){
            l.add(candidates[i]);
            dfs(candidates,l,target-candidates[i],i+1);
            int j = i;
            while(j > 0 && j < candidates.length && candidates[j] == candidates[j-1]){
                j++;
            }
            if(i != j){
                i = j - 1;
            }
            l.remove(l.size()-1);
        }
    }
}
