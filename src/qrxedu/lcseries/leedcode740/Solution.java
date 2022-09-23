package qrxedu.lcseries.leedcode740;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 删除并获得点数:当删除nums[i]后获得nums[i]个点数,并将nuns[i]-1和nums[i]+1清零
 * 这里要理解:当我们选择删除nums[i]之后,将nums[i]+1清零否都无所谓,因为是在cnt[i]中i和i+1和i-1是相邻的
 * 只需要考虑i-1和i-2
 * f[i] = Math.max(f[i-1](不删除nums[i]),f[i-2]+i*cnt[i](删除nums[i]))
 * 可以统计每个元素出现的次数的原因是当选择删除某个值后,和它相同的值再删除就没有任何影响,为了尽可能的点数大
 * 我们如果选中删除某个值,则一定会将出现在其他地方的这个值全部加上.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int deleteAndEarn(int[] nums){
        int[] cnt = new  int[10010];
        int max = 0;
        if(nums.length == 1){
            return nums[0];
        }
        for(int num : nums){
            cnt[num]++;
            max = Math.max(num,max);
        }
        if(max == 1){
            return cnt[1];
        }
        int[] f = new int[max+1];
        f[1] = nums[1];
        f[2] = Math.max(nums[1],nums[2]);
        for(int i = 3; i <= max; i++){
            f[i] = Math.max(f[i-1],f[i-2]+cnt[i]*i);
        }
        return f[max];
    }


    public int ans = 0;
    public int deleteAndEarn1(int[] nums) {
        Arrays.sort(nums);
        dfs(0,nums,0);
        return ans;
    }
    public void dfs(int index,int[] nums,int cur){
        if(index == nums.length){
            ans = Math.max(ans,cur);
            return;
        }
        int[] curNum = Arrays.copyOf(nums,nums.length);
        int l = index-1;int r = index+1;
        while(l >= 0 && nums[l] > nums[index]-2){
            if(nums[l] == nums[index]-1){
                curNum[l] = 0;
            }
            l--;
        }
        while(r < nums.length && nums[r] < nums[index]+2){
            if(nums[r] == nums[index]+1){
                curNum[r] = 0;
            }
            r++;
        }
        dfs(index+1,curNum,cur+nums[index]);
        dfs(index+1,nums,cur);
    }
    @Test
    public void show(){
        int[] arr = {3,4,2};
        System.out.println(deleteAndEarn1(arr));
    }
}
