package qrxedu.leedcode1818;

import java.util.Arrays;

/**
 * 对nums1中的每个元素通过二分找到和nums2中对应元素最接近的值.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    static int MOD = (int)1e9+7;
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] nums = nums1.clone();
        Arrays.sort(nums);
        int n = nums1.length;
        int[] ans = new int[n];
        long sum = 0;
        for(int i = 0; i < n; i++){
            ans[i] = Math.abs(nums1[i] - nums2[i]);
            sum += ans[i];
            sum %= MOD;
        }
        if(sum == 0){
            return 0;
        }
        long res = 0;
        for(int i = 0; i < n; i++){
            int key = nums2[i];
            int l = 0, r = n - 1;
            while(l < r){
                int mid = l + r + 1 >> 1;
                if(nums[mid] >= key){
                    r = mid - 1;
                }else{
                    l = mid;
                }
            }
            int tmp1 = nums[l];
            int cur = Math.abs(nums2[i] - tmp1);
            if(l + 1 < n){
                cur = Math.min(cur,Math.abs(nums2[i] - nums[l+1]));
            }
            res = Math.min(res%MOD,(sum-ans[i]+cur)%MOD);
        }
        //如果最终求得的是负数,而且上面没有什么问题,最终结果就需要加个MOD
        return (int)(res+MOD)%MOD;
    }
}
