package qrxedu.lcseries.leedcode29;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        long a = dividend;
        long b = divisor;
        boolean flag = false;
        if(a < 0 && b > 0 || a > 0 && b < 0){
            flag = true;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        long l = 0;
        long r = (long)Integer.MAX_VALUE+1;
        while(l < r){
            long mid = l + r + 1 >> 1;
            long res = func(mid,b);
            if(res <= a){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        if(flag){
            l = -l;
        }
        if(l >Integer.MAX_VALUE || l < Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }else{
            return (int)l;
        }
    }
    public long func(long a,long b){
        long res = 0;
        long i = 0;
        while(b >> i > 0){
            if(((b >>i) & 1) == 1){
                res += a;
            }
            i++;
            a += a;
        }
        return res;
    }
    @Test
    public void show(){
        System.out.println(divide(1026117192
                ,-874002063));
    }
}
