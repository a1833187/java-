package com.qrxedu.queue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class RingQueue {
    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(5);
        circleQueue.addQueue(1);
        circleQueue.addQueue(2);
        circleQueue.addQueue(3);
        circleQueue.addQueue(4);
        circleQueue.display();
        circleQueue.getQueue();
        circleQueue.display();
        circleQueue.addQueue(5);
        circleQueue.display();
    }
}

class CircleQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = 0;
        rear = 0;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断队列是否已满
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 向队列中添加元素
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满,无法添加数据");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 取出队列元素
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列已空，无法取出元素");
        }
        int n = arr[front];
        front = (front + 1) % maxSize;
        return n;
    }

    /**
     * 展示队列
     */
    public void display() {
        if (isEmpty()) {
            System.out.println("队列为空，无元素");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("%d\t", arr[i%maxSize]);
        }
        System.out.println();
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
