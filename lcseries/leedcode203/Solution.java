package com.qrxedu.lcseries.leedcode203;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，
 * 并返回新的头节点 。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur!= null){
            if(cur.val == val){
                pre.next = cur.next;
                cur = pre.next;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        if(head.val == val){
            return head.next;
        }
        return head;
    }
}
