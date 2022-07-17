package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E4 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ListNode cur1 = new ListNode(list1.val);
                cur.next = cur1;
                cur = cur1;
                list1 = list1.next;
            }else{
                ListNode cur2 = new ListNode(list2.val);
                cur.next = cur2;
                cur = cur2;
                list2 = list2.next;
            }
        }
        cur.next = list1 == null ? list2 : list1;
        return dummy.next;

    }
}
