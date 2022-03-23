package qrxedu.leedcode39;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    List<Integer> list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,candidates,target,0);
        return res;
    }
    public void dfs(List<List<Integer>> res,int[] candidates,int target,int index){
        if(target <= 0){
            if(target == 0){
                List<Integer> l = new ArrayList<>(list);
                res.add(l);
            }
            return;
        }
        for(int i = index; i < candidates.length;i++){
            list.add(candidates[i]);
            dfs(res,candidates,target-candidates[i],i);
            list.remove(list.size()-1);
        }
    }
    @Test
    public void show(){
        int[] arr = {2,3,6,7};
        System.out.println(combinationSum(arr,7));
    }
}
