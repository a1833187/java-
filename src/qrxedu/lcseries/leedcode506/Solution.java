package qrxedu.lcseries.leedcode506;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String[] findRelativeRanks(int[] score) {
        String[] first = {"Gold Medal","Silver Medal","Bronze Medal"};
        Map<Integer,Integer> map = new HashMap<>();
        int[] arr = Arrays.copyOf(score,score.length);
        Arrays.sort(arr);
        for(int i = 0; i < arr.length;i++){
            map.put(arr[i],arr.length-i-1);
        }
        String[] out = new String[arr.length];
        for(int i = 0; i < arr.length;i++) {
            int rank = map.get(score[i]);
            out[i] = rank < 3? first[rank]:Integer.toString(rank+1);
        }
        return out;
    }
    @Test
    public void show(){
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10,3,8,9,4})));
    }
}
