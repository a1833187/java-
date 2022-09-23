package qrxedu.lcseries.leedcode88;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m+n];
        int i = 0, j = 0;
        int k = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                nums[k++] = nums1[i++];
            }else{
                nums[k++] = nums2[j++];
            }
        }
        if(i == m){
            for(;j < n; j++){
                nums[k++] = nums2[j];
            }
        }else{
            for(;i < m; i++){
                nums[k++] = nums1[i];
            }
        }
        i = 0;
        for(; i < m+n; i++){
            nums1[i] = nums[i];
        }
    }
}
