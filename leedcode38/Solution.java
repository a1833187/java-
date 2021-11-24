package com.qrxedu.leedcode38;

import java.util.Stack;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        int len = s.length();
        if(len == 0){
            return 0;
        }
        int count = 0;
        while(true){
            if(s.charAt(index) == '('){
                stack.push(s.charAt(index));
            }else{
                if(!stack.empty()){
                    stack.pop();
                    count+=2;
                }
            }
            if(index == len - 1){
                break;
            }
            index ++;
        }
        return count;
    }
}
