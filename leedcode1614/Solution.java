package com.qrxedu.leedcode1614;

import java.util.Stack;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int len = 0;
        for(int i = 0; i < arr.length;i++){
            if(arr[i] == '('){
                stack.push(arr[i]);
            }
            if(arr[i] == ')'){
                stack.pop();
            }
            if(len < stack.size()){
                len = stack.size();
            }
        }
        return len;
    }
}
