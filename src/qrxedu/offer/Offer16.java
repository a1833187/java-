package qrxedu.offer;

import org.junit.jupiter.api.Test;

/**
 * 快速幂:
 * 考虑n为负数取倒数
 * 考虑Integer.MIN_VALUE转成正数会溢出,所以要单独考虑
 * 处理的方式:
 * 1.把n转成long型,一劳永逸
 * 2.Integer.MIN_VALUE先转成Integer.MAX_VALUE,然后最后再乘x
 * @author qiu
 * @version 1.8.0
 */
public class Offer16 {
    public double myPow(double x, int n) {
        double curX = x;
        double ans = 1.0;
        boolean flag = true;
        boolean min = false;
        if(n < 0){
            if(n == Integer.MIN_VALUE){
                n = Integer.MAX_VALUE;
                min = true;
            }else {
                n = -n;
            }
            flag = false;
        }
        for(int i = n; i > 0; i >>= 1){
            if(i % 2 == 1){
                ans = ans * x;
            }
            x = x * x;
        }
        if(!flag){
            if(min){
                return 1/(ans * curX);
            }
            return 1/ans;
        }
        return ans;
    }
    @Test
    public void show(){
        System.out.println(myPow(-1,Integer.MIN_VALUE));

    }
}
