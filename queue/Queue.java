package com.qrxedu.queue;

/**
 * 用数组模拟带头节点的单队列(即front指向队列头部的前一个节点)
 * @author qiu
 * @version 1.8.0
 */
public class Queue {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
        arrayQueue.display();
        arrayQueue.addQueue(4);
        arrayQueue.display();
    }
}
class ArrayQueue{
    //数组最大容量
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = -1;
        rear = -1;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull(){
        return rear == maxSize-1;
    }

    /**
     * 向队列中添加元素
     */
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列已满,无法添加数据");
            return;
        }
        arr[++rear] = n;
    }

    /**
     * 取出队列元素
     */
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列已空，无法取出元素");
        }
        return arr[++front];
    }

    /**
     * 展示队列
     */
    public void display(){
        if(isEmpty()){
            System.out.println("队列为空，无元素");
            return;
        }
        for(int i = front+1;i<=rear;i++){
            System.out.printf("%d\t",arr[i]);
        }
        System.out.println();
    }



}
