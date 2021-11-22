package com.qrxedu.leedcode232;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author qiu
 * @version 1.8.0
 */
public class MyQueue {
    Stack<Integer> stack = new Stack<>();
    public MyQueue() {

    }

    /**
     * 将元素 x 推到队列的末尾
     * @param x
     */
    public void push(int x) {
        stack.add(0,x);
    }

    /**
     *从队列的开头移除并返回元素
     * @return
     */
    public int pop() {
        return stack.pop();
    }

    /**
     *返回队列开头的元素
     * @return
     */
    public int peek() {
        return stack.peek();
    }

    /**
     *如果队列为空，返回 true ；否则，返回 false
     * @return
     */
    public boolean empty() {
        return stack.empty();
    }

}
