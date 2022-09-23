package qrxedu.lcseries.leedcode1838;

import java.util.Arrays;

/**
 * 找一个最大的符合条件的区间长度 可以用 "二分"来做!
 * 二分区间的长度(从0~n),check每个len是否能够满足.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    int[] nums;
    int[] sum;
    int n,k;
    public int maxFrequency(int[] _nums, int _k) {
        nums = _nums;
        k = _k;
        n = nums.length;
        Arrays.sort(nums);
        sum = new int[n+1];
        for(int i = 0; i < n; i++){
            sum[i+1] = sum[i] + nums[i];
        }
        int l = 0,r = n;
        while(l < r){
            int mid = l + r + 1 >> 1;
            if(check(mid)){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
    public boolean check(int len){
        for(int l = 0; l + len - 1 < n; l++){
            int r = l + len - 1;
            int total = nums[r] * len;
            int cur = sum[r+1] - sum[l];
            //注意这里如果用cur + k >= total 来判断cur+k可能会越界
            if(total - cur <= k){
                return true;
            }
        }
        return false;
    }
}
