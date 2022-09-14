package qrxedu.lcseries.leedcode25;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode[]> l = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            int t = 0;
            ListNode prev = cur;
            while (prev != null) {
                prev = prev.next;
                t++;
                if (t == k) {
                    break;
                }
            }
            if (t == k) {
                t = 1;
                prev = cur;
                ListNode next = prev.next;
                while (t < k) {
                    ListNode curNext = next.next;
                    next.next = prev;
                    prev = next;
                    next = curNext;
                    t++;
                }
                ListNode[] arr = new ListNode[2];
                arr[0] = cur;
                arr[1] = prev;
                cur = next;
                l.add(arr);
            } else {
                // 其实这如果好好处理一下的话,后面就不需要讨论了...
                l.add(new ListNode[]{cur, null});
                break;
            }
        }
        if (l.size() > 1) {
            if (l.get(l.size() - 1)[1] == null) {
                // 正好k个链表
                for (int i = 0; i < l.size() - 2; i++) {
                    l.get(i)[0].next = l.get(i + 1)[1];
                }
                l.get(l.size() - 2)[0].next = l.get(l.size() - 1)[0];
            } else {

                // 最后一个小于k的链表没有发生反转
                for (int i = 0; i < l.size() - 1; i++) {
                    l.get(i)[0].next = l.get(i + 1)[1];
                }
                l.get(l.size() - 1)[0].next = null;
            }
        }else{
            // 当只有1个链表发生反转时,需要把原来链表的头结点的next置位null,否则成环了
            l.get(0)[0].next = null;
        }

        return l.get(0)[1];
    }

    @Test
    public void show(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(reverseKGroup(n1,2));
    }
}
