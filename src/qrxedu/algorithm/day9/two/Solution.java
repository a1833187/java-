package qrxedu.algorithm.day9.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到所有连续的正整数的和为num的序列。
 * 滑动窗口
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<List<Integer>> findContinuousSequence(int num) {
        List<List<Integer>> res = new ArrayList<>();
        int low = 1;
        int high = 2;
        int sum;
        while (low < high) {
            sum = (low + high) * (high - low + 1) / 2;
            if(sum < num){
                high++;
            }else if(sum > num){
                low++;
            }else{
                List<Integer> list = new ArrayList<>();
                for(int i = low; i <= high;i++){
                    list.add(i);
                }
                res.add(list);
                low++;
            }
        }
        return res;
    }
}
