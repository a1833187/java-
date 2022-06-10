package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer24 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode mid = head;
        ListNode end = head.next;
        while(end != null){
            mid.next = prev;
            prev = mid;
            mid = end;
            end = end.next;
        }
        mid.next = prev;
        return mid;
    }
}
