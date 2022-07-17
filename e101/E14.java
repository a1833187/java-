package qrxedu.e101;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E14 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        ListNode cur = head;
        while (cur != null) {
            ListNode node = new ListNode(cur.val);
            cur1.next = node;
            cur1 = node;
            cur = cur.next;
            if (cur == null) {
                break;
            }
            cur = cur.next;
        }
        cur = head.next;
        while (cur != null) {
            ListNode node = new ListNode(cur.val);
            cur2.next = node;
            cur2 = node;
            cur = cur.next;
            if (cur == null) {
                break;
            }
            cur = cur.next;
        }
        cur1.next = dummy2.next;
        return dummy1.next;
    }

    /**
     * 不借助其他链表,在链表本身进行操作
     * @param head
     * @return
     */
    public ListNode oddEvenList1(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode j = head;
        ListNode o = head.next;
        ListNode curJ = j;
        ListNode curO = o;
        while ( curO.next != null) {
            curJ.next = curO.next;
            curJ = curO.next;
            if (curJ.next != null) {
                curO.next = curJ.next;
                curO = curJ.next;
            }else{
                break;
            }
            curJ.next = o;
        }
        curJ.next = o;
        curO.next = null;
        return head;
    }

    @Test
    public void show() {
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(1);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(5);
        ListNode h5 = new ListNode(6);
        ListNode h6 = new ListNode(4);
        ListNode h7 = new ListNode(7);
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;
        h5.next = h6;
        h6.next = h7;
        System.out.println(oddEvenList1(h1));
    }
}
