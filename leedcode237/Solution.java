package com.qrxedu.leedcode237;

/**
 * 请编写一个函数，用于 删除单链表中某个特定节点。
 * 在设计函数时需要注意，你无法访问链表的头节点head ，只能直接访问 要被删除的节点 。
 * 题目数据保证需要删除的节点 不是末尾节点 。

 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public void deleteNode(ListNode node) {
        ListNode cur = node.next;
        while(cur.next != null){
            node.val = cur.val;
            node = node.next;
            cur = cur.next;
        }
        node.val = cur.val;
        node.next = null;
    }
}
