package qrxedu.leedcode1004;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    int[] nums;
    int k,n;
    int[] sum;
    public int longestOnes(int[] _nums, int _k) {
        nums = _nums;
        k = _k;
        n = nums.length;
        sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) {
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
    public boolean check(int mid){
        for(int l = 0; l + mid - 1 < n; l++){
            int r = l + mid - 1;
            int cur = sum[r+1] - sum[l];
            if(cur + k >= mid){
                return true;
            }
        }
        return false;
    }
}
