package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E9 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode (int val){
            this.val = val;
        }
    }
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        if(head == null){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode curr = head;
        while(n != 0){
            if(curr == null){
                return null;
            }
            curr = curr.next;
            n--;
        }
        if(curr == null){
            return cur.next;
        }
        while(curr != null){
            pre = cur;
            cur = cur.next;
            curr = curr.next;
        }
        pre.next = cur.next;

        return head;
    }
}
