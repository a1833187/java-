package qrxedu.leedcode148;

import org.junit.jupiter.api.Test;

import java.awt.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode sortList(ListNode head){
        return sortList(head,null);
    }
    public ListNode sortList(ListNode head,ListNode tail){
        if(head == null){
            return head;
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
        ListNode sorted =  merge(list1,list2);
        return sorted;
    }
    public ListNode merge(ListNode l1,ListNode l2){
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        ListNode cur1 = l1,cur2 = l2;
        while(cur1!=null&&cur2!=null){
            if(cur1.val<=cur2.val){
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
        return newHead.next;
    }

    @Test
    public void show(){
        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(3);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        sortList(head);
    }
}
