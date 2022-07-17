package qrxedu.e101;

import org.junit.jupiter.api.Test;

/**
 * 区间翻转链表
 * @author qiu
 * @version 1.8.0
 */
public class E1 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        if (m == n || head == null) {
            return head;
        }
        int idx = 1;
        ListNode be = null;
        ListNode af = null;
        ListNode cur = head;
        ListNode ppre = null;
        ListNode pre = null;
        ListNode pro = null;
        ListNode ppro = null;
        while (idx <= n) {
            if (idx == m - 1) {
                ppre = cur;
                pre = cur;
            }
            if (idx == m) {
                be = cur;
            }
            if (idx == n) {
                af = cur;
            }
            idx++;
            cur = cur.next;
        }
        cur = be;
        pro = be.next;
        while (cur != af) {
            ListNode newPro = pro.next;
            pro.next = cur;
            cur.next = pre;
            pre = cur;
            cur = pro;
            pro = newPro;
        }
        if(ppre != null){
            ppre.next = af;
        }
        be.next = ppro;
        if(ppre == null){
            return cur;
        }
        return head;
    }
    @Test
    public void show(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(reverseBetween(l1,2,4));
    }
}
