package com.qrxedu.lcseries.leedcode20;

import java.util.Stack;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(true){
            if(!stack.empty()){
                if(isLeft(s.charAt(index))){
                    stack.push(s.charAt(index));
                }else{
                    if(isMatch(stack.peek(),s.charAt(index))){
                        stack.pop();
                    }else{
                        return false;
                    }
                }
            }else{
                if(isLeft(s.charAt(index))){
                    stack.push(s.charAt(index));
                }else{
                    return false;
                }
            }
            if(index == s.length()-1){
                break;
            }
            index++;
        }
        return stack.empty();
    }

    public boolean isLeft(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    public boolean isMatch(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')') ||
                (ch1 == '{' && ch2 == '}' || (ch1 == '[' && ch2 == ']'));
    }
}
