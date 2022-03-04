package qrxedu.algorithm.day5.one;

import java.util.Stack;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();
    public void push(int val){
        if(stackMin.empty() || stackMin.peek() > val){
            stackMin.push(val);
        }else{
            stackMin.push(stackMin.peek());
        }
        stack.push(val);
    }
    public int pop(){
        int val = stack.pop();
        stackMin.pop();
        return val;
    }
    public int min(){
        return stackMin.peek();
    }
    public int top(){
        return stack.peek();
    }
}
