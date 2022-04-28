package qrxedu.leedcode673;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] cnt = new int[n];
        int maxLen = 1;
        int[] f = new int[n];
        f[0] = 1;
        for(int i = 0; i < n; i++){
            f[i] = 1;
            cnt[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(f[j]+1 > f[i]){
                        f[i] = f[j]+1;
                        cnt[i] = cnt[j];
                    }else if(f[i]==f[j]+1){
                        cnt[i]+=cnt[j];
                    }
                }
            }
            if(maxLen < f[i]){
                maxLen = f[i];
                ans = cnt[i];
            }else if(maxLen == f[i]){
                ans += cnt[i];
            }
        }
        return ans;
    }
    @Test
    public void show(){
        int[] arr = {2,2,2,2,2};
        System.out.println(findNumberOfLIS(arr));
    }
}
