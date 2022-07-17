package qrxedu.e101;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E11 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode (int val){
            this.val = val;
        }
    }
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        ListNode h1 = reverse(head1);
        ListNode h2 = reverse(head2);
        ListNode cur1 = h1;
        ListNode cur2 = h2;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int k = 0;
        while(cur1 != null && cur2 != null){
            int val = cur1.val + cur2.val + k;
            ListNode node = new ListNode((val) % 10);
            cur.next = node;
            cur = node;
            if(val >= 10){
                k = 1;
            }else{
                k = 0;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if(cur1 == null){
            while(cur2 != null){
                int val = cur2.val + k;
                ListNode node = new ListNode(val % 10);
                cur.next = node;
                cur = node;
                if(val >= 10){
                    k = 1;
                }else{
                    k = 0;
                }
                cur2 = cur2.next;
            }
        }else{
            while(cur1 != null){
                int val = cur1.val + k;
                ListNode node = new ListNode(val % 10);
                cur.next = node;
                cur = node;
                if(val >= 10){
                    k = 1;
                }else{
                    k = 0;
                }
                cur1 = cur1.next;
            }
        }
        if(k == 1){
            ListNode node = new ListNode(1);
            cur.next = node;
            cur = cur.next;
        }
        ListNode end = dummy.next;
        ListNode newHead = reverse(dummy.next);
        end.next = null;
        return newHead;
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode mid = head;
        ListNode end = head.next;
        while(end != null){
            ListNode curEnd = end.next;
            end.next = mid;
            mid.next = pre;
            pre = mid;
            mid = end;
            end = curEnd;
        }
        return mid;
    }
    @Test
    public void show(){
        ListNode h1 = new ListNode(9);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(7);
        ListNode h4 = new ListNode(6);
        ListNode h5 = new ListNode(3);
        h1.next = h2;
        h2.next = h3;
        h4.next = h5;
        addInList(h1,h4);
    }
}
