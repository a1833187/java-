package qrxedu.lcseries.leedcode15;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题解 :排序+双指针
 * 三个数相加的和为0,当三个数中有两个数确定时,另外一个数唯一确定或者不存在。
 * 将数组进行排序，从头开始，定两个数，然后让另一个指针从结尾遍历这两个数之后的位置
 * 每次遍历为了防止重复，前面两个确定的元素要求相邻元素重复时只能取一次，因为有序数组中重复的元素一定是相邻的
 * @author qiu
 * @version 1.8.0
 */
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int end = nums.length - 1;
                if (j == end) {
                    break;
                }
                //相较于三重循环而言，
                while (j < end && nums[i] + nums[j] + nums[end] > 0) {
                    end--;
                }
                if (nums[i] + nums[j] + nums[end] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[end]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }

    /**
     * 将数组中所有重复的元素全部删掉: [1 1 2 2 3 3] ===> []
     * @param list
     */
    public void deleteAll(List<Integer> list){
        int i = 0;
        while(i<list.size()-1){
            if((i+1)<list.size()&&list.get(i).equals(list.get(i + 1))){
                while((i+1)<list.size()&&list.get(i).equals(list.get(i+1))){
                    list.remove(i+1);
                }
                list.remove(i);
            }else{
                i++;
            }
        }
    }

    /**
     * 将数组中重复的元素只保留一个：[1 1 2 2 3 3] ===> [1 2 3]
     * @param list
     */
    public void deleteAllButOne(List<Integer> list){
        int i = 0;
        while(i < list.size()-1){
            if((i+1)<list.size()&&list.get(i).equals(list.get(i+1))){
                list.remove(i+1);
            }else{
                i++;
            }
        }
    }
    @Test
    public void show(){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        System.out.println(list);
        deleteAllButOne(list);
        /*deleteAll(list);*/
        System.out.println(list);
    }
}
