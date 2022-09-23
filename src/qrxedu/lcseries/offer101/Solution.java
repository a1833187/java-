package qrxedu.lcseries.offer101;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    int MOD = (int)(Math.pow(10,9)+7);
    public int fib(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int n1 = 0;
        int n2 = 1;
        int n3 = n1 + n2;
        while(n >= 2){
            n3 = (n1 + n2)%MOD;
            n1 = n2;
            n2 = n3;
            n--;
        }
        return n2;
    }
    @Test
    public void show(){
        System.out.println(fib(9));
    }
}
