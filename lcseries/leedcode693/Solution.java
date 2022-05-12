package qrxedu.leedcode693;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean hasAlternatingBits(int n) {
        //按照符合规则的二进制的和来算
        for(int i = 1; i <= 16; i++){
            long tmp = (long)(Math.pow(4,i))-1;
            if(tmp % 3 != 0){
                continue;
            }
            tmp/=3;
            if(tmp > n || tmp >= Integer.MAX_VALUE){
                break;
            }
            if(n == tmp || n == 2*tmp){
                return true;
            }
        }
        return false;


//        按照每一位进行比较.
//        if(n == 1){
//            return true;
//        }
//        int k = 0;
//        int cur = n;
//        while(cur != 0){
//            cur >>= 1;
//            k++;
//        }
//        int n0 = n & 1;
//        int n1 = (n >> 1)&1;
//        boolean flag = true;
//        for(int i = 2; i < k; i+=2){
//            int curN = (n >> i) & 1;
//            if(curN != n0){
//                return false;
//            }
//        }
//        for(int i = 3; i < k;i+=2){
//            int curN = (n >> i) & 1;
//            if(curN != n1){
//                return false;
//            }
//        }
//        return true;
    }
    @Test
    public void show(){
        System.out.println(hasAlternatingBits(1431655765));
    }
}
