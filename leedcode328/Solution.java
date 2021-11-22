package com.qrxedu.leedcode328;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode odd = head;
        ListNode oven = head.next;
        ListNode tmp = head.next;
        //链表中只有1个元素或2个元素
        if(oven == null||oven.next == null){
            return head;
        }
        while(odd.next.next!= null||oven.next.next!= null){
            if(odd.next.next!= null){
                odd.next = odd.next.next;
                odd = odd.next;
            }
            if(oven.next.next!= null){
                oven.next = oven.next.next;
                oven = oven.next;
            }
            //!!!!
            if(oven.next == null||odd.next == null){
                break;
            }
        }
        //连接两个"断开"的链表
        odd.next = tmp;
        oven.next = null;
        return head;

    }
}
