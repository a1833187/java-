package com.qrxedu.stack;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Test {
    public static void main(String[] args) {
            Stack stack = new Stack(4);
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.display();
            System.out.println(stack.pop());
            stack.display();
        }
}
