package JavaSe_exam;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur = cur2;
                cur2 = cur2.next;
            }
        }
        if (cur1 == null) {
            cur.next = cur2;
        }
        if (cur2 == null) {
            cur.next = cur1;
        }
        return newHead.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
