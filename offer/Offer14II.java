package qrxedu.offer;

import org.junit.jupiter.api.Test;

/**
 * 数学解法:因为n的取值变大,所以原本乘积较大的值可能因为求余后变得更小,所以通过dp或枚举不能得到最大值
 * 通过几何均值不等式得出n要尽可能的切分成相等的份数乘积最大
 * 通过求导得出当切出来的每份最接近e时乘积最大,最接近e的整数为3.
 * @author qiu
 * @version 1.8.0
 */
public class Offer14II {
    static int MOD = (int)1e9+7;
    public int cuttingRope(int n) {
       if(n <= 3){
           return n-1;
       }
       long ans = 1L;
       int r = n % 3;
       long x = 3;
       //这里的n/3-1将r==0的情况也包含在内,最后同一考虑剩余的那个数(3,4,5).
       for(int i = n/3-1;i>0;i/=2){
           if(i % 2 == 1) {
               ans = (ans * x) % MOD;
           }
           x = (x * x) % MOD;
       }
       if(r == 0){
           return (int)(ans * 3%MOD);
       }
       if(r == 1){
           return (int)(ans * 4 % MOD);
       }
           return (int)(ans * 6 % MOD);
    }
    @Test
    public void show(){
        System.out.println(cuttingRope(120));
    }
}
