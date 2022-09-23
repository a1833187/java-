package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E7 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null || pHead.next == null){
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while(fast != slow && fast != null){
            slow = slow.next;
            if(fast.next != null){
                fast = fast.next;
            }
            fast = fast.next;
        }
        if(fast == null){
            return null;
        }
        slow = pHead;
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
