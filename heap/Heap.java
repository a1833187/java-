package com.qrxedu.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Heap {
    int[] elem;
    int usedSize;
    public Heap(){
        elem = new int[10];
    }
    public void createHeap(int[] array){
        for(int i = 0; i < array.length; i++){
            elem[i] = array[i];
            usedSize++;
        }
        for(int parent = (usedSize-2)/2; parent >= 0; parent--){
            //建大堆的时间复杂度为O(n),
            // 极端情况下一个堆为满二叉树，
            // 错位相减法得到时间复杂度为2^h-h-1，h为堆的高度。
            shiftDown(parent,usedSize);
        }
    }

    /**
     * 向下调整，建立大根堆
     * @param parent
     * @param len
     */
    public void shiftDown(int parent,int len){
        int child = 2*parent + 1;
        while (child < len){
            if(child + 1 < len && elem[child] < elem[child+1]){
                child += 1;
            }
            if(elem[child] > elem[parent]){
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2 * parent + 1;
            }else{
                break;
            }
        }
    }
    public boolean isFull(){
        return usedSize == elem.length;
    }
    public void offer(int val){
        if(isFull()){
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        elem[usedSize++] = val;
        shiftUp(usedSize-1);

    }
    public void shiftUp(int child){
        int parent = (child-1) / 2;
        while(child > 0){
            child = Math.max(elem[parent*2+1],elem[parent*2+2]);
            if(elem[child] > elem[parent]){
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                child = parent;
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }
    public boolean isEmpty(){
        return usedSize == 0;
    }
    public int poll(){
        if(isEmpty()){
            throw new RuntimeException("优先级队列为空");
        }
        int tmp = elem[0];
        elem[0] = elem[usedSize - 1];
        elem[usedSize - 1] = tmp;
        usedSize--;
        shiftDown(0,usedSize);
        return tmp;
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("优先级队列为空");
        }
        return elem[0];
    }

    public static void main(String[] args) {
        //java中的优先级队列默认为 小堆
        //每次弹出一个元素后剩余的堆为小堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    }
}
