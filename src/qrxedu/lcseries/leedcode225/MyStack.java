package qrxedu.lcseries.leedcode225;


import java.util.LinkedList;

/**
 * @author qiu
 * @version 1.8.0
 */
public class MyStack {
    public LinkedList<Integer> queue = new LinkedList<>();
    public MyStack() {

    }

    /**
     * 将元素 x 压入栈顶。
     * @param x
     */
    public void push(int x) {
      queue.addFirst(x);
    }

    /**
     * 移除并返回栈顶元素。
     * @return
     */
    public int pop() {
        return queue.pollLast();
    }

    /**
     * 返回栈顶元素
     * @return
     */
    public int top() {
        return queue.peekLast();
    }

    /**
     *  如果栈是空的，返回 true ；否则，返回 false
     * @return
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
