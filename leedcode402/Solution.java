package com.qrxedu.leedcode402;

import java.util.Stack;

/**
 * 移除k位数字
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) {
            return "0";
        }
        StringBuilder sb = new StringBuilder(num);
        int index = 0;
        int j;
        for(int i = 0; i < k; i++){
            for(j = 1; j <sb.length();j++){
                if(sb.charAt(j)<sb.charAt(j-1)){
                    index = j;
                    break;
                }
            }
            sb.delete(j-1,j);
        }
        while(sb.length()!=1&&sb.charAt(0) == '0'){
            sb.delete(0,1);
        }
        return sb.toString();
    }
}
