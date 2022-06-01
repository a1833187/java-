package qrxedu.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Offer9 {
    Deque<Integer> d1;
    Deque<Integer> d2;

    public Offer9() {
        d1 = new LinkedList<>();
        d2 = new LinkedList<>();
    }

    /*
    d1作为输入栈,d2作为输出栈
     */
    public void offer(int val) {
        d1.push(val);
    }

    public int poll() {
        //注意只有d2空了才会从d1中索取内容.
        if (d2.isEmpty()) {
            if (d1.isEmpty()) {
                return -1;
            }
            //这里作了一步简化,并不需要再把所有值从d2再转到d1
            while (!d1.isEmpty()) {
                d2.push(d1.pop());
            }
        }
        return d2.pop();
    }



    public void appendTail(int value) {
        d1.push(value);
    }

    public int deleteHead() {
        if (d1.size() != 0) {
            while (d1.size() != 1) {
                d2.push(d1.pop());
            }
            int ans = d1.pop();
            //把d2中的值再移回到d1
            while (d2.size() != 0) {
                d1.push(d2.pop());
            }
            return ans;
        }
        return -1;
    }
}
