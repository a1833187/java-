package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E15 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode deleteDuplicates (ListNode head) {
        // write code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = head;
        while(end != null){
            if(end.next != null && end.val == end.next.val){
                while(end.next != null && end.val == end.next.val){
                    end = end.next;
                }
                pre.next = end;
            }
            pre = end;
            end = end.next;
        }
        return dummy.next;
    }
}
