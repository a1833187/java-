package qrxedu.lcseries.leedcode1711;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    int MOD = (int)1e9+7;
    public int countPairs(int[] deliciousness) {
        int m = deliciousness.length;
        int max = 0;
        for(int num : deliciousness){
            max = Math.max(max,num);
        }
        int p = 1;
        while(p < max * 2){
            p*=2;
        }
        //为了防止重复计算以及计算两次本身,我们统一先遍历后统计
        //这样做既可以避免将两个本值相加的结果统计上
        //也可以避免重复计算:因为7+9=16,只需要在9的时候统计一次7即可.也就是统计d[i]前面哪个值和自己相加满足条件
        Map<Integer,Integer> dict1 = new HashMap<>();
        int ans = 0;
        for(int num : deliciousness){
            for(int i = 1; i <= p; i<<=1){
                ans += dict1.getOrDefault(i-num ,0);
                ans %= MOD;
            }
            dict1.put(num,dict1.getOrDefault(num,0)+1);
        }
        return ans;
    }
    @Test
    public void show(){
        int[] d = {1,3,5,7,9};
        System.out.println(countPairs(d));
        System.out.println(MOD);
    }
}
