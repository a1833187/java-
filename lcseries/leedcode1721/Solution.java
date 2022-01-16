package com.qrxedu.lcseries.leedcode1721;

/**
 * 给你链表的头节点 head 和一个整数 k 。
 * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
 *
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k - 1; i++) {
            fast = fast.next;
        }
        ListNode cur = fast;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
            int temp = cur.val;
            cur.val = slow.val;
            slow.val = temp;
        return head;
    }
}
