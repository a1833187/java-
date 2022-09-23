package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E2 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode pro = head.next;
        while(pro != null){
            ListNode newPro = pro.next;
            pro.next = cur;
            cur.next = pre;
            pre = cur;
            cur = pro;
            pro = newPro;
        }
        head = cur;
        return head;
    }
}
