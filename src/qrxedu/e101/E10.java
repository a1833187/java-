package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E10 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        int len1 = getLength(pHead1);
        int len2 = getLength(pHead2);
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        if(len1 < len2){
            int diff = len2 - len1;
            while(diff != 0){
                cur2 = cur2.next;
                diff--;
            }
        }else{
            int diff = len1 - len2;
            while(diff != 0){
                cur1 = cur1.next;
                diff--;
            }
        }
        while(cur1 != cur2 && cur1 != null){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    public int getLength(ListNode head){
        if(head == null){
            return 0;
        }
        int len = 1;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        return len;
    }
}
