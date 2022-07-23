package qrxedu.e101;

import java.util.Stack;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E43 {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public void push(int node) {
        s1.push(node);
        if(s2.empty()){
            s2.push(node);
        }else{
            if(node <= s2.peek()){
                s2.push(node);
            }
        }
    }

    public void pop() {
        int val = s1.pop();
        if(val == s2.peek()){
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
