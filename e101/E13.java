package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E13 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode (int val){
            this.val = val;
        }
    }
    public boolean isPail (ListNode head) {
        // write code here
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode cur = reverse(head);
        if(fast == null){
            cur = cur.next;
        }
        while(cur != null && tmp != null){
            if(cur.val != tmp.val){
                return false;
            }
            cur = cur.next;
            tmp = tmp.next;
        }
        return true;
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
}
