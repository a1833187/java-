package com.qrxedu.leedcode374;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int guess(int n){
        return 0;
    }
    public int guessNumber(int n) {
        int k = guess(n);
        if(k == 0){
            return n;
        }
        if(k < 0){
            int m = n;
            while(k < 0){
                m = m / 2;
                k = guess(m);
            }
            if(k == 0){
                return m;
            }else{
                return find(m,n);
            }
        }
        if(k > 0){
            int m = n;
            while(k > 0){
                m = n * 2;
                k = guess(m);
            }
            if(k == 0){
                return m;
            }else{
                return find(n,m);
            }
        }
        return -1;
    }
    public int find(int low,int high){
        while(low < high){
            //不能用mid = (low+high)/2，因为low + high 可能 越界。
            int mid = low + (high - low) /2;
            if(guess(mid) < 0){
                high = mid;
            }else if(guess(mid) > 0){
                low = mid;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
