package qrxedu.algorithm.day1.three;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 找到数组中出现次数超过一半的数字，如果没有则返回0
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    //用map存储所有数字出现的次数。
    public int findMaxNumber1(int[] nums){
        int half = nums.length / 2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Set<Integer> set = map.keySet();
        for(int i : set){
            if(map.get(i) > half){
                return i;
            }
        }
        return 0;
    }
    //对数组排序，如果存在，则排序后的数组的中间元素即为所求，否则返回0
    public int findMaxNumber2(int[] nums){
        Arrays.sort(nums);
        int num = nums[nums.length/2];
        int i = nums.length / 2-1, j = nums.length / 2+1;
        int count = 0;
        while(i >= 0){
            if(num == nums[i]){
                count++;
                i--;
            }else{
                break;
            }
        }
        while(j < nums.length){
            if(num == nums[j]){
                count++;
                j++;
            }else{
                break;
            }
        }
        return count > nums.length/2?num:0;
    }

    //两个数字不相等则都删去，相等进行下一次比较，如果该值存在，则数组中最后剩余的数字一定即为所求
    //但在遍历的过程中同时进行删除比较麻烦，所以用time来统计抵消(删除)次数！！！
    public int findMaxNumber3(int[] nums){
        //防止下面的循环越界
        if(nums.length == 0){
            return 0;
        }
        int time = 1;
        int half = nums.length / 2;
        int num = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(time == 0){
                time = 1;
                num = nums[i];
            }else if(num == nums[i]){
                time++;
            }else{
                time--;
            }
        }
        //循环结束后如果该值存在，则time一定大于0，且num 即为所求，但仍需遍历一次进行验证。
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(num == nums[i]){
                count++;
            }
        }
        return count > half?num:0;
    }
}
