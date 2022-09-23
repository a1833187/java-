package qrxedu.lcseries.leedcode611;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 双指针
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        if(nums.length < 3){
            return 0;
        }
        int cnt = 0;
        Arrays.sort(nums);
        int beg = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                beg++;
            }else{
                break;
            }
        }
        int k = beg + 2;
        for(int i = beg; i < n; i++){
            //每次i动的时候,k得更新.
            k = i;
            for(int j = i + 1; j < n; j++){
                while(k < n && nums[i]+nums[j] > nums[k]){
                    k++;
                }
                cnt += k - j-1;
            }
        }
        return cnt;
    }

    /**
     * 二分
     * @param nums
     * @return
     */
    public int triangleNumber1(int[] nums){
        int n = nums.length;
        if(nums.length < 3){
            return 0;
        }
        int cnt = 0;
        Arrays.sort(nums);
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int l = j + 1, r = n-1;
                while(l < r){
                    int mid = l + r + 1 >> 1;
                    if(nums[i]+nums[j] > nums[mid]){
                        l = mid;
                    }else{
                        r = mid - 1;
                    }
                }
                //这里还需要判断一下,因为有可能就不进while循环,比如j=n-2.
                cnt += nums[r] < nums[i]+nums[j] ? r-j : 0;
            }
        }
        return cnt;
    }
    @Test
    public void show(){
        int[] nums = {4,2,3,4};
        System.out.println(triangleNumber(nums));
    }
}
