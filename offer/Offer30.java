package qrxedu.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer30 {
    Deque<Integer> s;
    Deque<Integer> minS;
    public Offer30() {
        s = new LinkedList<>();
        minS = new LinkedList<>();
    }

    public void push(int x) {
        s.push(x);
        if(minS.size() == 0 || x <= minS.peek()){
            minS.push(x);
        }
    }

    public void pop() {
        int x = s.pop();
        if(x == minS.peek()){
            minS.pop();
        }

    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return minS.peek();
    }
}
