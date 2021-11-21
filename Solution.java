package com.qrxedu.leedcode5;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        String output = "";
        for(int i = 0; i < len; i++){
            char[] chars = s.substring(i).toCharArray();
            char[] chars1 = findMax(chars);
            output = output.length()>chars1.length?output:new String(chars1);
        }
        return output;
    }
    public char[] findMax(char[] chars){
        int len = chars.length;
        int i = len - 1;
        int j;
        for(; i >= 0; i--){
            if(chars[i] == chars[0]){
                for(j = 0; j < (i+1)/2; j++){
                    if(chars[j]!=chars[i-j]){
                        break;
                    }
                }
                if(j == (i+1)/2){
                    char[] chars1 = new char[i+1];
                    for(int k = 0; k < chars1.length;k++){
                        chars1[k] = chars[k];
                    }
                    return chars1;
                }
            }
        }
       return new char[0];
    }
}
