package com.qrxedu.lcseries.leedcode1716;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int totalMoney(int n) {
        int sum = 0;
        int a = 1;
        while(n>7){
            sum+=(2*a+6)*7/2;
            n-=7;
            a++;
        }
        sum+=(2*a+n-1)*n/2;
        return sum;
    }
}
