package qrxedu.algorithm.day8.two;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String printMinNumber(Integer[] nums){
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString() + o2.toString();
                String s2 = o2.toString() + o1.toString();
                return s1.compareTo(s2);
            }
        });
        String result = "";
        for(int i = 0; i < nums.length;i++){
            result += nums[i].toString();
        }
        return result;
    }
}
