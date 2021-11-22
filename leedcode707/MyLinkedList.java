package com.qrxedu.leedcode707;

import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class MyLinkedList {
    class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;
    public MyLinkedList() {

    }

    /**
     * 获取链表中第 index 个节点的值。如果索引无效，则返回-1。
     * @param index
     * @return
     */
    public int get(int index) {
        if(index<0||head == null){
            return -1;
        }
        if(head.next == null&&index == 0){
            return head.val;
        }
        ListNode cur = head;
        for(int i = 0; i < index;i++){
            if(cur == null){
                return -1;
            }
            cur = cur.next;
        }
        if(cur!= null) {
            return cur.val;
        }
        return -1;
    }

    /**
     * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
     * @param val
     */
    public void addAtHead(int val) {
        ListNode m = new ListNode(val);
        if(head == null){
            head = m;
        }else{
            m.next = head;
            head = m;
        }
    }

    /**
     * 将值为 val 的节点追加到链表的最后一个元素
     * @param val
     */
    public void addAtTail(int val) {
        ListNode m = new ListNode(val);
        if(head == null){
            head = m;
        }else{
            ListNode cur = head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = m;
        }
    }

    /**
     * 在链表中的第index个节点之前添加值为val的节点。
     * 如果index等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。
     * 如果index小于0，则在头部插入节点。
     *
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        ListNode m = new ListNode(val);
        if(index <= 0){
            addAtHead(val);
            return;
        }
        int len = 0;
        ListNode pre = null;
        ListNode cur = head;
        for(int i = 0; i < index;i++){
            if(cur == null){
                break;
            }
            if(cur.next == null&&(i+1)==index){
                addAtTail(val);
                return;
            }
            pre = cur;
            cur = cur.next;
        }
        if(cur != null) {
            pre.next = m;
            m.next = cur;
        }
    }

    /**
     * 如果索引 index 有效，则删除链表中的第 index 个节点。
     * @param index
     */
    public void deleteAtIndex(int index) {
        if(index < 0||head == null){
            return;
        }
        if(index == 0){
            head = head.next;
            return;
        }
        ListNode pre = null;
        ListNode cur = head;
        for(int i = 1; i <= index;i++){
            if(cur == null){
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if(cur != null){
            if(cur.next == null){
                pre.next = null;
            }else{
                pre.next = cur.next;
                cur.next = null;
            }
        }
    }
}
