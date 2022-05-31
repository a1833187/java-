package qrxedu.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中重复的数字:元素大小为1~n-1
 * 鸽巢原理:将每个元素放在数组中对应的索引上,如果一个索引上的数字出现了两次,就返回改数字.
 * @author qiu
 * @version 1.8.0
 */
public class Offer3 {
    public int findRepeatNumber(int[] nums) {
        //O(n) + O(1)
        for(int i = 0; i < nums.length; i++){
            //while确保要报索引i上存放的元素就是i.
            while(nums[i] != i){
                if(nums[nums[i]] == nums[i]){
                    return nums[i];
                }
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        return -1;
    }
    public int findRepeatNumber1(int[] nums){
        //hash  O(n) + O(n)
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                return num;
            }
            map.put(num,1);
        }
        return -1;
    }
}
