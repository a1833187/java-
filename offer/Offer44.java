package qrxedu.offer;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer44 {
    static long[] sum = new long[11];
    static{
        for(int i = 1; i <= 10; i++){
            sum[i] = sum[i-1] + 9L *i*(int)Math.pow(10,i-1);
        }
    }
    public int findNthDigit(int n) {
        if(n == 0){
            return 0;
        }
        //在单个值的数位为index的区间A内
        int index = 0;
        for(int i = 0; i < 10; i++){
            if(sum[i] < n && sum[i+1] >=n){
                index = i+1;
                break;
            }
        }
        n -= sum[index-1];
        //p为区间A内第p个值num
        int p = (n+index-1)/index;
        //p为num中的第p位(以0开始)
        int pp = (n+index-1)%index;
        int num = (int)Math.pow(10,index-1)+p-1;
        return num /(int)Math.pow(10,index-pp-1) % 10;
    }
    @Test
    public void show(){
        System.out.println(findNthDigit(1000000000));
    }
}
