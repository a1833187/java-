package qrxedu.leedcode82;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode cur = head;
        if(cur.next!= null && cur.val == cur.next.val){
            while(cur.next!= null && cur.val == cur.next.val){
                cur = cur.next;
            }
            cur = cur.next;
        }else{
            prev.next = cur;
            prev = prev.next;
            cur = cur.next;
        }
        return dummy.next;
    }
    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
