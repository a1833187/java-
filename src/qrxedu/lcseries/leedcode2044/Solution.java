package qrxedu.lcseries.leedcode2044;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int count = 0;
    public int countMaxOrSubsets(int[] nums) {
        int maxNum = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxNum = maxNum | nums[i];
        }
        dfs(nums,maxNum,0,0);
        return count;
    }
    public void dfs(int[] nums,int maxNum,int index,int curNum){
        if(index == nums.length){
            return;
        }
        for(int i = index; i < nums.length;i++){
            int n = curNum;
            curNum = curNum | nums[i];
            if(curNum == maxNum){
                count++;
            }
            dfs(nums,maxNum,i+1,curNum);
            curNum = n;
        }
    }

    /**
     * 每个数字都有选和不选两个状态，分别对应dfs1(val)和dfs1(val|nums[u])
     * @param nums
     * @param u
     * @param val
     * @param maxNum
     */
    public void dfs1(int[] nums,int u,int val,int maxNum){
        if(u == nums.length){
            if(val == maxNum){
                count++;
            }
            return;
        }
        dfs1(nums,u+1,val,maxNum);
        dfs1(nums,u+1,val|nums[u],maxNum);
    }
    @Test
    public void show(){
        int[] nums = {3,2,1,5};
        System.out.println(countMaxOrSubsets(nums));;
    }

}
