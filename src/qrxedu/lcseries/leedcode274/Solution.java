package qrxedu.lcseries.leedcode274;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for(int h = citations[len - 1]; h >= 0; h--){
            int index = find(citations,h);
            if(len - index >= h){
                return h;
            }
        }
        return 0;
    }
    public int find(int[] nums,int key){
       for(int i = 0; i < nums.length-1; i++){
           if(nums[i] < key && nums[i+1] >= key){
               if(nums[i] == nums[i+1]){
                   return i;
               }else{
                   return i+1;
               }
           }
       }
       return 0;
    }

    @Test
    public void show(){
        int[] nums = {3,0,6,1,5};
        System.out.println(hIndex(nums));
    }
}
