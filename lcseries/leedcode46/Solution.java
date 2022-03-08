package qrxedu.leedcode46;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    List<Integer> list;
    boolean[] isVisited;
    int count = 0;
    public List<List<Integer>>  permute(int[] nums) {
        list = new ArrayList<>();
        isVisited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        dfs(0,res,nums);
        return res;
    }
    public void dfs(int index,List<List<Integer>> res,int[] nums){
        if(count == nums.length){
            List<Integer> list1 = new ArrayList<>(list);
            res.add(list1);
            return;
        }
        for(int i = index;i< nums.length;i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                list.add(nums[i]);
                count++;
                dfs(index,res,nums);
                list.remove(list.size()-1);
                isVisited[i] = false;
                count--;
            }
        }
    }
}
