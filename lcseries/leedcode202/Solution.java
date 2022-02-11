package com.qrxedu.leedcode202;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isHappy(int n) {
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        while(n%2==0 || n%3==0 || n%5==0){
            if(n%2==0){
                n = n / 2;
            }else if(n%3==0){
                n = n / 3;
            }else if (n%5==0){
                n = n / 5;
            }
        }
        return n == 1;
    }
}
