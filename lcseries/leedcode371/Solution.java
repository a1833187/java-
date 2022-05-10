package qrxedu.leedcode371;

import org.junit.jupiter.api.Test;

/**
 * 不用运算符号实现两个数相加:&<<1代表进位的相加;^代表不进位的相加
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int getSum(int a, int b) {
        int jin = (a & b)<<1;
        int jia = a ^ b;
        while(jin != 0){
            int cur = jin;
            jin = (jia & jin) <<1;
            jia = jia ^ cur;

        }
        return jia;
    }
    @Test
    public void show(){
        System.out.println(getSum(2,3));
    }
}
