package qrxedu.lcseries.leedcode295;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author qiu
 * @version 1.8.0
 */
class MedianFinder {
    PriorityQueue<Integer> minQ;
    PriorityQueue<Integer> maxQ;
    public MedianFinder() {
        minQ  = new PriorityQueue<>();
        maxQ = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return o2-o1;
            }
        });

    }

    public void addNum(int num) {
        int minSize = minQ.size();
        int maxSize = maxQ.size();
        if(minSize <= maxSize){
            maxQ.offer(num);
            minQ.offer(maxQ.poll());
        }else{
            minQ.offer(num);
            maxQ.offer(minQ.poll());
        }

    }

    public double findMedian() {
        if((minQ.size() + maxQ.size()) % 2 == 0){
            return (minQ.peek() + maxQ.peek()) * 1.0 / 2;
        }else{
            return minQ.peek() * 1.0;
        }
    }
}
