package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E50 {
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int n = numbers.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(numbers[i],i);
        }
        int pre = 0;int end = 0;
        for(int i = 0; i < n; i++){
            int t = target - numbers[i];
            if(map.containsKey(t) && map.get(t) != i){
                end = i;
                pre = map.get(t);
                break;
            }
        }
        if(pre > end){
            int tmp = pre;
            pre = end;
            end = tmp;
        }
        return new int[]{pre+1,end+1};

    }
    @Test
    public void show(){
        int[] arr = {3,2,4};
        System.out.println(Arrays.toString(twoSum(arr, 6)));
    }
}
