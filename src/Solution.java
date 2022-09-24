import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< nums.length;i++){
            if(nums[i] == target){
                list.add(i);
            }
        }
        return list;
    }
}
