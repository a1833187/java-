package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E8 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode (int val){
            this.val = val;
        }
    }
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        if(pHead == null || k == 1){
            return pHead;
        }
        ListNode cur = pHead;
        while(k != 0){
            if(cur == null){
                return null;
            }
            cur = cur.next;
            k--;

        }
        ListNode curr = pHead;
        while(cur != null){
            curr = curr.next;
            cur = cur.next;
        }
        return curr;
    }
}
