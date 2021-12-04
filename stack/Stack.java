package com.qrxedu.stack;

import org.junit.jupiter.api.Test;

/**
 * 数组模拟栈
 * @author qiu
 * @version 1.8.0
 */
public class Stack {
    private int maxSize;
    private int top = -1;
    private int[] stack;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top == maxSize-1;
    }
    public boolean isEmpty(){
        return top == -1;
    }

    /**
     * 入栈
     * @param val
     */
    public void push(int val){
        if(isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = val;
    }

    /**
     * 出栈
     */
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        int val = stack[top];
        top--;
        return val;
    }

    /**
     * 显示栈中元素(自上至下)
     */
    public void display(){
        if(isEmpty()){
            System.out.println("栈为空");
            return;
        }
        for(int i = top; i>=0; i--){
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}
