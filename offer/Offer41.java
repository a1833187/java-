package qrxedu.offer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Offer41 {
    List<Integer> list;
    int size = 0;
    /** initialize your data structure here. */
    public Offer41() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        if(size == 0){
            list.add(num);
        }else{
            int i = 0;
            for(; i < size; i++){
                if(list.get(i) >= num) {
                    break;
                }
            }
            list.add(i,num);
        }
        size++;
    }

    public double findMedian() {
        if (size % 2 != 0) {
            return (double) list.get(size / 2);
        }else{
            return (list.get(size/2)+list.get(size/2-1))/2.0;
        }
    }

    @Test
    public void show(){
        addNum(1);
        addNum(2);
        System.out.println(findMedian());
    }
}
@SuppressWarnings("all")
class  MedianFinder {
    //大根堆存放数组中较小的一半值
    PriorityQueue<Integer> maxQ;
    //小根堆存放数组中较大的一半值
    PriorityQueue<Integer> minQ;
    public MedianFinder(){
        maxQ = new PriorityQueue<>((o1,o2)->(o2-o1));
        minQ= new PriorityQueue<>();
    }
    //至于奇数个值时哪个堆里面存放多的值则随意,只要对应就行
    public void addNum(int num){
        if(maxQ.size() != minQ.size()){
            minQ.add(num);
            maxQ.add(minQ.poll());
        }else{
            maxQ.add(num);
            minQ.add(maxQ.poll());
        }
    }
    public double findMedian(){
        if(maxQ.size() == minQ.size()){
            return (maxQ.peek()+minQ.peek())/2.0;
        }else{
            return minQ.peek();
        }
    }
    @Test
    public void show(){
        addNum(1);
        addNum(2);
        addNum(3);
        System.out.println(findMedian());
    }
}
