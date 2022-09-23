package qrxedu.lcseries.leedcode565;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    List<Integer> list;
    int[] len = new int[1];
    boolean[] isVisited;
    public int arrayNesting(int[] nums) {
        list = new ArrayList<>();
        isVisited = new boolean[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length;i++){
            if(!isVisited[i]) {
                dfs(nums, i);
                if (max < len[0]) {
                    max = len[0];
                }
            }
        }
        return max;
    }
    public void dfs(int[] nums,int index){
        if(list.contains(nums[index])){
           len[0] = list.size();
           return;
        }
        list.add(nums[index]);
        isVisited[index] = true;
        dfs(nums,nums[index]);
        list.remove(list.size()-1);

    }
    @Test
    public void show(){
        int[] nums = {5,4,0,3,1,6,2};
        System.out.println(arrayNesting(nums));
    }
}
