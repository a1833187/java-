package qrxedu.lcseries.leetcode146;

import java.util.HashMap;

/**
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；
 * 如果关键字不存在，则插入该组「关键字-值」。当
 * 缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 */
public class LRUCache1 {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public int capacity;

    public int size;

    public Node head, tail;
    public HashMap<Integer, Node> map;

    public LRUCache1(int capacity) {
        if (capacity >= 0) {
            this.capacity = capacity;
        } else {
            this.capacity = -1;
            //-1表示容量没有限制
        }
        map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null && node.next != null && node.prev != null) {
            //中间节点存在prev和next
            node.prev.next = node.next;
            node.next.prev = node.prev;

            head.prev = node;
            node.next = head;
            node.prev = null;
            this.head = node;
            return node.value;
        } else if (node != null && node.prev == null) {
            //首节点不存在prev，null←■→←□
            return node.value;
        } else if (node != null && node.next == null) {
            //尾节点不存在next
            Node lastNode = node.prev;
            lastNode.next = null;
            head.prev = node;
            node.next = head;
            node.prev = null;
            this.head = node;
            this.tail = lastNode;
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if (size == 0) {
            Node curNode = new Node(key, value, null, null);
            head = curNode;
            tail = curNode;
            map.put(key, curNode);
            size++;
            return;

        } else {
            Node node = map.get(key);
            if (node == null) {
                //直接添加到首节点
                Node curNode = new Node(key, value, null, null);
                head.prev = curNode;
                curNode.next = head;
                this.head = curNode;
                map.put(key, curNode);
                size++;
                if (size > capacity && capacity != -1) {
                    Node lastNode = tail.prev;
                    lastNode.next = null;
                    tail.prev = null;
                    map.remove(tail.key);
                    this.tail = lastNode;
                    size--;

                }
            } else {
                //中间节点存在prev和next，□→←■→←□
                if (node != null && node.next != null && node.prev != null) {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;

                    head.prev = node;
                    node.next = head;
                    node.prev = null;
                    this.head = node;
                    node.value = value;
                } else if (node != null && node.prev == null) {
                    //首节点不存在prev，null←■→←□
                    node.value = value;
                } else if (node != null && node.next == null) {
                    //尾节点不存在next，□→←■→null
                    Node lastNode = node.prev;
                    lastNode.next = null;
                    head.prev = node;
                    node.next = head;
                    node.prev = null;
                    this.head = node;
                    this.tail = lastNode;
                    node.value = value;
                }
            }
        }
    }
}
