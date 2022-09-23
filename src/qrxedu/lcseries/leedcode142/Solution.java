package qrxedu.lcseries.leedcode142;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        if(fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        while(fast!=null && fast != slow){
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
        }
        slow = head;
        if(fast == null){
            return null;
        }
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
