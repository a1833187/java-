package qrxedu.lcseries.leedcode155;

import java.util.Stack;

/**
 * @author qiu
 * @version 1.8.0
 */
public class MinStack {
    public Stack<Integer> stack1;
    public Stack<Integer> stack2;
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);
        if(stack2.isEmpty()){
            stack2.push(val);
        }else{
            if(val > stack2.peek()){
                stack2.push(stack2.peek());
            }else{
                stack2.push(val);
            }
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
