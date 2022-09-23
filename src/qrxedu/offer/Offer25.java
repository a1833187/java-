package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer25 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode yummy = new ListNode(-1);
        ListNode cur = yummy;
        ListNode cur1 = l1, cur2 = l2;
        while(cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                cur.next = cur1;
                cur = cur1;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur = cur2;
                cur2 = cur2.next;
            }
        }
        cur.next = cur1 == null ? cur2 : cur1;
        return yummy.next;
    }
}
