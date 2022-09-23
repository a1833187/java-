package qrxedu.lcseries.leedcode5934;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        if(nums.length == k){
            return nums;
        }
        int[] out = new int[k];
        int[][] map = new int[nums.length][2];
        for(int i = 0; i < nums.length;i++){
            map[i][0] = i;
            map[i][1] = nums[i];
        }
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int[] arr1 = new int[k];
        int m = 0;
        for(int i = arr.length-1;i>=arr.length-k;i--){
            for(int j = 0; j < arr.length;j++){
                if(arr[i] == map[j][1]){
                    arr1[m++] = map[j][0];
                    map[j][1] = Integer.MAX_VALUE;
                    break;
                }
            }
        }
        Arrays.sort(arr1);
        m = 0;
        for(int i = 0; i < nums.length;i++){
            if(m<k) {
                out[m] = nums[arr1[m]];
                m+=1;
            }else{
                break;
            }
        }
        return out;
    }
    @Test
    public void show(){
        int[] nums = {18,3,19,-8,30,22,-35,11,16,18,-21,32,-7,-6,38,25,-21,-1,26,-8,-37,-39,-34,6,-36,-3,26,-32,22,-20,35,-35,-30,-8,11,7,-23,-9,-22,1,33,-6,12,2,27,-27,28,-12,21,12,16,21,33};
        System.out.println(Arrays.toString(maxSubsequence(nums,50)));
        int[] nums1 = {2,1,3,3};
        System.out.println(Arrays.toString(maxSubsequence(nums1,2)));
    }
}
