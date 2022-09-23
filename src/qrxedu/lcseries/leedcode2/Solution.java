package qrxedu.lcseries.leedcode2;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = size(l1) >= size(l2) ? l1 : l2;
        ListNode cur2 = size(l1) < size(l2) ? l1 : l2;
        int j = 0;
        while(cur1 != null && cur2 != null){
            int c = cur1.val + cur2.val + j;
            cur1.val = (cur1.val + cur2.val + j) % 10;
            if(c >= 10){
                j = 1;
            }else{
                j = 0;
            }
            if(cur1.next == null && j == 1){
                cur1.next = new ListNode(0);
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while(cur1 != null){
            int c = cur1.val + j;
            cur1.val = (cur1.val + j) % 10;
            if(c >= 10){
                j = 1;
            }else{
                j = 0;
            }
            if(cur1.next == null && j == 1){
                cur1.next = new ListNode(0);
            }
            cur1 = cur1.next;
        }
        return size(l1) >= size(l2) ? l1 : l2;
    }
    public int size(ListNode head){
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
}
