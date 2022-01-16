package com.qrxedu.lcseries.leedcode1446;

import org.junit.jupiter.api.Test;

/**
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * 请你返回字符串的能量。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxPower(String s) {
        if(s.length()==1){
            return 1;
        }
        int max = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                sb.append(s.charAt(i));
            }else{
                if(max<=sb.length()){
                    max = sb.length()+1;
                }
                sb = new StringBuilder();
            }
        }
        return Math.max(max,sb.length()+1);
    }
    @Test
    public void show(){
        System.out.println(maxPower("cc"));
    }
}
