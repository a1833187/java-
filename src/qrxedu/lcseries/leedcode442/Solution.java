package qrxedu.lcseries.leedcode442;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int[] arr = new int[nums.length+1];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length;i++){
            arr[nums[i]]++;
            if(arr[nums[i]] == 2){
                list.add(nums[i]);
            }
        }
        return list;
    }
}
