package com.qrxedu.leetcode146;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Node {
    public int key;
    public int value;
    public int capacity;
    public int useTime = 0;
    public int size;
    public Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node() {
    }
}
