package qrxedu.leedcode21;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        if(cur1!=null){
            cur.next = cur1;
        }else{
            cur.next = cur2;
        }
        return dummy.next;
    }
}
