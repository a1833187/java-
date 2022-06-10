package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer22 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode  fast = head;
        while(k-- > 0){
            fast = fast.next;
        }
        ListNode slow = head;
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
