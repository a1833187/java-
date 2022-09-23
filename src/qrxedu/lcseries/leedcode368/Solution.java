package qrxedu.lcseries.leedcode368;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] f = new int[n];
        int maxSize = 1;
        int maxVal = 0;
        f[0] = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    f[i] = Math.max(f[i],f[j]+1);
                }
            }
            if(maxSize < f[i]){
                maxSize = f[i];
                maxVal = nums[i];
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(maxSize == 1){
            ans.add(nums[0]);
            return ans;
        }
        for(int i = n-1; i >= 0; i--){
            if(maxSize == f[i] && maxVal % nums[i] == 0){
                ans.add(nums[i]);
                maxSize--;
                maxVal = nums[i];
            }
        }
        return ans;
    }
    @Test
    public void show(){
        int[] arr = {1,2,6,12,4};
        System.out.println(largestDivisibleSubset(arr));
    }
}
