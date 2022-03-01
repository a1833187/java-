package qrxedu.algorithm.day3.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    //求斐波那契数列的第n项(递归+剪枝)
    public int fib(int n){
        if(n <= 1){
            return n;
        }
        int ppre = 0;
        if(map.containsValue(n-2)){
            ppre = map.get(n-2);
        }else{
            ppre = fib(n-2);
            map.put(n-2,ppre);
        }
        int pre = 0;
        if(map.containsValue(n-1)){
            pre = map.get(n-1);
        }else{
            pre = fib(n-1);
            map.put(n-1,pre);
        }
        return ppre + pre;

    }
}
