package com.qrxedu.leedcode278;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isBadVersion(int n){
        return true;
    }
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
