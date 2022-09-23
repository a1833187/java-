package qrxedu.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer64 {
    Deque<Integer> q;
    Deque<Integer> maxQ;
    public Offer64() {
        q = new LinkedList<>();
        maxQ = new LinkedList<>();
    }

    public int max_value() {
        if(q.size() == 0){
            return -1;
        }
        return maxQ.peekFirst();
    }

    public void push_back(int value) {
        q.offerLast(value);
        while(!maxQ.isEmpty() && value > maxQ.peekLast()){
            maxQ.pollLast();
        }
        maxQ.offerLast(value);
    }

    public int pop_front() {
        if(q.size() == 0){
            return -1;
        }
        if(maxQ.peekFirst().equals(q.peekFirst())){
            maxQ.pollFirst();
        }
        return q.pollFirst();
    }
}
