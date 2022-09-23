package qrxedu.lcseries.leedcode933;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class RecentCounter {
    public Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
            queue.offer(t);
            while(!queue.isEmpty()&&queue.peek()<t-3000){
                queue.poll();
            }
        return queue.size();
    }
}
