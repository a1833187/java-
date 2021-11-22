package com.qrxedu.leetcode148;

/**
 * @author qiu
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;

        while(head!=null) {
            ListNode cur1 = head;
            ListNode tmp = head;
            ListNode pre = null;
            while (cur1 != null && cur1.next != null) {
                if (tmp.val > cur1.next.val) {
                    pre = cur1;
                    tmp = cur1.next;
                }
                cur1 = cur1.next;
            }
            if (pre == null) {
                head = head.next;
            } else {
                pre.next = tmp.next;
            }
            cur.next = tmp;
            cur = tmp;
        }
        return newHead.next;
    }
}
