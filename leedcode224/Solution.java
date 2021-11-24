package com.qrxedu.leedcode224;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int calculate(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        char ch = ' ';
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        ArrayList<Character> in = new ArrayList<>();
        for(int j = 0; j < s.length(); j++){
            in.add(s.charAt(j));
        }
        if(in.get(0)=='-'&&in.get(1)>='0'&&in.get(1)<='9'){
            in.add(0,'0');
        }
        for(int i = 0; i < in.size()-1;i++){
            if((in.get(i) == '('||in.get(i) == ' ')&&in.get(i+1) == '-'){
                in.add(i+1,'0');
            }
        }
        System.out.println(in);
        for(int i = 0; i < in.size();i++){
            ch = in.get(i);
            if(ch == ' '){
            }else if(ch == '+' || ch == '-'){
                if(stack.empty() || stack.peek() == '('){
                    stack.push(ch);
                }else{
                    num1 = numStack.pop();
                    if(numStack.empty()){
                        num2 = 0;
                    }else {
                        num2 = numStack.pop();
                    }
                    if(stack.peek() == '+'){
                        res = num1 + num2;
                        stack.pop();
                    }else{
                        res = num2 - num1;
                        stack.pop();
                    }
                    numStack.push(res);
                    stack.push(ch);
                }
            }else if(ch == '(' || ch == ')'){
                if(ch == '('){
                    stack.push(ch);
                }else{
                    while(true){
                        num1 = numStack.pop();
                        if(numStack.empty()){
                            res = num1;
                            numStack.push(res);
                            if(stack.peek() == '('){
                                stack.pop();
                            }
                            break;
                        }
                        num2 = numStack.pop();
                        if(stack.peek() == '+'){
                            res = num1 + num2;
                            stack.pop();
                        }else{
                            res = num2 - num1;
                            stack.pop();
                        }
                        numStack.push(res);
                        if(stack.peek() == '('){
                            stack.pop();
                            break;
                        }
                    }
                }
            }else{
                String n = "";
                n+=in.get(i);
                while((i+1)<in.size()&&in.get(i+1)>='0'&&in.get(i+1)<='9'){
                    n+=in.get(i+1);
                    i++;
                }
                numStack.push(Integer.parseInt(n));
            }
        }
        if(numStack.size()==1){
            return numStack.pop();
        }
        while(!stack.empty()){
            num1 = numStack.pop();
            if(numStack.empty()){
                num2 = 0;
            }else {
                num2 = numStack.pop();
            }
            if(stack.peek() == '+'){
                res = num1 + num2;
                numStack.push(res);
            }else{
                res = num2 - num1;
                numStack.push(res);
            }
            stack.pop();
        }
        return numStack.pop();

    }

    /*
     *   public int calculate(String s) {
     *         Stack<Integer> stack = new Stack<Integer>();
     *         // sign 代表正负
     *         int sign = 1, res = 0;
     *         int length = s.length();
     *         for (int i = 0; i < length; i++) {
     *             char ch = s.charAt(i);
     *             if (Character.isDigit(ch)) {
     *                 int cur = ch - '0';
     *                 while (i + 1 < length && Character.isDigit(s.charAt(i + 1)))
     *                     cur = cur * 10 + s.charAt(++i) - '0';
     *                 res = res + sign * cur;
     *             } else if (ch == '+') {
     *                 sign = 1;
     *             } else if (ch == '-') {
     *                 sign = -1;
     *             } else if (ch == '(') {
     *                 stack.push(res);
     *                 res = 0;
     *                 stack.push(sign);
     *                 sign = 1;
     *             } else if (ch == ')') {
     *                 res = stack.pop() * res + stack.pop();
     *             }
     *         }
     *         return res;
     *     }
     */

    public void show(){
        Object[] o = new Object[3];
        String[] ss = (String[]) o;
        for(int i = 0; i < o.length;i++){
            ss[i] = (String)o[i];
        }
    }

}
