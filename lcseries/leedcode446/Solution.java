package qrxedu.leedcode446;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 当某个维度的范围过大时可以考虑用哈希表来替代该维度.
 * f[i][j] ---> f[i],i下标的元素为Map<j:num>,其中j对应第二维度,num对应f[i][j]的值
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        List<Map<Long,Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Map<Long,Integer> map = new HashMap<>();
            for(int j = 0; j < i; j++){
                Long d = ((long) nums[i] - nums[j]);
                int cnt = list.get(j).getOrDefault(d,0);
                //这里加1是因为要考虑个数为2的等差数列,因为该数列可能会在之后构造成个数等于3的等差数列
                cnt++;
                map.put(d,map.getOrDefault(d,0)+cnt);
            }
            list.add(map);
        }
        int cnt = 0;
        //求得个数大于等于2的等差舒蕾
        for(int i = 0; i < n; i++){
            Set<Long> set = list.get(i).keySet();
            for(Long d : set){
                cnt+=list.get(i).get(d);
            }
        }
        //个数为2的等差数列是不符合条件的,其个数为Cn2(排列数)
        int dd = n * (n-1)/2;
        return cnt - dd;
    }
    @Test
    public void show(){
        int[] nums = {0,2000000000,-294967296};
        System.out.println(numberOfArithmeticSlices(nums));
    }
}
