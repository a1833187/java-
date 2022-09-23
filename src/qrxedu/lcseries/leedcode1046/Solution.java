package qrxedu.lcseries.leedcode1046;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int num : stones){
            priorityQueue.add(num);
        }
        while(priorityQueue.size() > 1){
            int top1 = priorityQueue.poll();
            int top2 = priorityQueue.poll();
            if(top1 > top2){
                priorityQueue.offer(top1 - top2);
            }
        }
        if(priorityQueue.size() == 1){
            return priorityQueue.peek();
        }else{
            return 0;
        }
    }
}
