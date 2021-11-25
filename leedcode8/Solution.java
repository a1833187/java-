package com.qrxedu.leedcode8;

import org.junit.jupiter.api.Test;

/**
 * 字符串转换整数 (atoi)
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        char ch = ' ';
        int res = 0;
        int sign = 1;
        int i = 0;
        int len = s.length();
        for(;i<len;i++){
            ch = s.charAt(i);
            if(ch == ' '){
                continue;
            }else if(ch == '-'){
                sign = -1;
                break;
            }else if(ch=='+'){
                sign = 1;
                break;
            }
            else{
                break;
            }
        }
        for(i = i + 1;i<len;i++){
            ch = s.charAt(i);
            if(ch>='0'&&ch<='9'){
                sb.append(ch);
            }else{
                break;
            }
        }
        if(sb.length() == 0){
            return 0;
        }
        int len1 = sb.length();
        for(int j = 0; j < len1-1;j++){
            if(sb.toString().charAt(0) == '0'){
                sb.delete(0,1);
            }
        }
        System.out.println(sb);
        System.out.println(sb.length());
        if(sb.length() > 10){
            if(sign == -1){
                return -2147483648;
            }else{
                return 2147483647;
            }
        }
        long l   = Long.parseLong(sb.toString());
        if(l*sign<=(-2147483648)){
            return -2147483648;
        }
        if(l*sign>=2147483647){
            return 2147483647;
        }
        res = Integer.parseInt(sb.toString());
        return res;
    }
    @Test
    public void show(){
        System.out.println(myAtoi("-000000000000000000000000000000000000000000000000001"));
    }
}
