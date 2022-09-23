package qrxedu.lcseries.leetcode148;

/**
 * @author qiu
 * @version 1.8.0
 * 归并排序
 */
public class Solution1 {
    public ListNode sortList(ListNode head){
        return sortList(head,null);
    }
    public ListNode sortList(ListNode head,ListNode tail){
        if(head == null){
            return null;
        }
        if(head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head,fast = slow;
        while(fast != tail){
            slow = slow.next;
            fast = fast.next;
            if(fast != tail){
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head,mid);
        ListNode list2 = sortList(mid,tail);
        return merge(list1,list2);

    }
    public ListNode merge(ListNode head1,ListNode head2){
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        ListNode cur1 = head1,cur2 = head2;
        while(cur1!=null&&cur2!=null){
            if(cur1.val<cur2.val){
                cur.next = cur1;
                cur = cur1;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur = cur2;
                cur2 = cur2.next;
            }
        }
        if(cur1 != null){
            cur.next = cur1;
        }else if(cur2 != null){
            cur.next = cur2;
        }
        return newHead.next;
    }
}
