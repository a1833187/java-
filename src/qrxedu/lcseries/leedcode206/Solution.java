package qrxedu.lcseries.leedcode206;

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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        ListNode cur1 = head;
        while(cur1 != null){
            ListNode res = cur1.next;
            cur1.next = cur.next;
            cur.next = cur1;
            cur1 = res;
        }
        return newHead.next;
    }
}
