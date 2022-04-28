package qrxedu.leedcode300;

/**
 * 还有一种做法是贪心+二分查找.
 * 贪心f[i]存放的是最长序列为i时最后一个元素的最小值.
 * 贪心思想:要想让递增数列中的元素个数尽可能的多,则应该让元素在递增时的幅度尽可能的小.
 * 虽然可能出现前面的递增序列的长度大于后面的,但因为已经记录过,且后面在覆盖前面时最终取得的也是二者之间
 * 最长的长度.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n =  nums.length;
        int[] f = new int[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            f[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    f[i] = Math.max(f[i],f[j]+1);
                }
            }
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }
}
