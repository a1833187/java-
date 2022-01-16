package com.qrxedu.lcseries.leedcode682;

import java.util.Stack;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int len = ops.length;
        for(int i = 0; i < len; i++){
            if("C".equals(ops[i])){
                if(!stack.empty()){
                    stack.pop();
                }
            }else if("D".equals(ops[i])){
                if(!stack.empty()){
                    int num = stack.peek();
                    stack.push(num*2);
                }
            }else if("+".equals(ops[i])){
                if(!stack.empty()){
                    int num1 = stack.pop();
                    int num2 = stack.peek();
                    stack.push(num1);
                    stack.push(num1+num2);
                }
            }else{
                stack.push(Integer.parseInt(ops[i]));
            }
        }
        while(!stack.empty()){
            int num = stack.pop();
            sum+=num;
        }
        return sum;
    }
}
