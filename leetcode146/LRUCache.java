package com.qrxedu.leetcode146;

/**
 * @author qiu
 * @version 1.8.0
 */
public class LRUCache {

    public Node head = new Node(-1,-1);
    public Node last;
    public LRUCache(int capacity) {
        head.capacity = capacity;
    }


    public int get(int key) {
        Node cur = head.next;
        while(cur != null){
            if(cur.key == key){
                cur.useTime++;
                return cur.key;
            }
            cur = cur.next;
        }
        return -1;
    }

    /**
     * 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
     * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
     */
    public void put(int key, int value) {
        Node n = new Node(key, value);

        if (head.size < head.capacity) {
            if (head.key == -1) {
                head = n;
                last = n;
            }
            Node cur = head;
            while (cur != null) {
                if (cur.key == key) {
                    cur.value = value;
                    break;
                }
                cur = cur.next;
            }
            if (cur == null) {
                last.next = n;
                last = n;
            }
            head.size++;
        }else{
            Node cur = head;
            Node tmp = cur;
            Node pre = null;
            while(cur!=null&&cur.next!=null){
                if(cur.useTime>cur.next.useTime){
                    pre = cur;
                    tmp = cur.next;
                }
                cur = cur.next;
            }
            tmp.key = key;
            tmp.value = value;
            if(tmp.next == null){
                last = pre;
            }
            if(pre == null){
                head = head.next;
            }else {
                pre.next = tmp.next;
            }
            head.size--;
        }
    }
}
