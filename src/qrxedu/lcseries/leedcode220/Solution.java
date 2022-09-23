package qrxedu.lcseries.leedcode220;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 给你一个整数数组 nums 和两个整数k 和 t 。
 * 请你判断是否存在 两个不同下标 i 和 j，
 * 使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * 如果存在则返回 true，不存在返回 false。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //Time Exceeding
        if(k == 0){
            return false;
        }
        if(k >= nums.length){
            k = nums.length-1;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i <= k; i++){
            arr.add(nums[i]);
        }

        for(int i = 0; i < nums.length-k;i++){
            arr.sort(Comparator.naturalOrder());
            ArrayList<Long> diff = new ArrayList<>();
            diff.add(Long.valueOf(arr.get(0)));
            for(int j = 1; j < arr.size();j++){
                diff.add( ((long)arr.get(j) - (long)(arr.get(j - 1))));
                if(diff.get(j) <= t){
                    return true;
                }
            }
            if(i+k+1 == nums.length){
                break;
            }
            Integer mm = nums[i];
            arr.remove(mm);
            arr.add(nums[i+k+1]);
        }
        return false;
        /*int[] diff = new int[k+1];
        diff[0] = arr[0];
        for(int i = 1; i <= k;i++){
            diff[i] = arr[i] - arr[i-1];
            if(diff[i] <= t){
                return true;
            }
        }*/

    }
    @Test
    public void show(){
        int[] nums = {-2147483648,2147483647};
        int k = 1, t = 1;
        System.out.println(containsNearbyAlmostDuplicate(nums,k,t));
    }

    /*
    利用treeSet有序集合存储元素
    顺序找一个abs(x-y)<=t的值
    treeSet能够将元素有序存储，
    treeSet.ceiling(k)作用为在treeSet集合中找到一个大于等于k的最小元素，找不到则返回null
      int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            先在目前的有序集合中去找到满足绝对值不等式的一个分式
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            如果这个数仍旧满足不等式的另一分式就返回true
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
     */
}
