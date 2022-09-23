package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E6 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
        public boolean hasCycle(ListNode head) {
            if(head == null || head.next == null){
                return false;
            }
            ListNode slow = head;
            ListNode fast = head;
            fast = fast.next;
            while(fast!=null){
                if(fast.next != null){
                    fast = fast.next;
                }else{
                    return false;
                }
                slow = slow.next;
                if(fast.next != null){
                    fast = fast.next;
                }else{
                    return false;
                }
                if(slow == fast){
                    return true;
                }
            }
            return fast == slow;
        }
    }
}
