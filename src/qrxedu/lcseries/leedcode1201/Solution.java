package qrxedu.lcseries.leedcode1201;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int nthUglyNumber(int n, int _a, int _b, int _c) {
        long l = 1, r = 2 * (int)1e9;
        long a = _a,b = _b,c = _c;
        while(l < r){
            long mid = l + r >>1;
            long cnt = getNum(mid,a) +getNum(mid,b) +getNum(mid,c) - getNum(mid,lcm(a,b))
                    -getNum(mid,lcm(a,c)) - getNum(mid,lcm(b,c)) + getNum(mid,lcm(a,lcm(b,c)));
            //>=的数都满足所以更新r
            if(cnt >= n){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return (int)l;
    }
    public long getNum(long n,long k){
        return n/k;
    }
    public long gcd(long a,long b){
        return b == 0 ? a : gcd(b,a%b);
    }
    public long lcm(long a,long b){
        return a / gcd(a,b) * b;
    }
    @Test
    public void show(){
        System.out.println(nthUglyNumber(4,2,3,4));
    }
}
