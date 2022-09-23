package qrxedu.algorithm.day8.three;

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
    public ListNode findTheFirstCommonNode(ListNode h1,ListNode h2){
        if(h1 == null || h2 == null){
            return null;
        }
        int len1 = lenOfNode(h1);
        int len2 = lenOfNode(h2);
        if(len1 < len2){
            ListNode tmp = h1;
            h1 = h2;
            h2 = tmp;
        }
        int diff = Math.abs(len1 - len2);
        ListNode cur1 = h1;
        ListNode cur2 = h2;
        while(diff > 0){
            cur1 = cur1.next;
            diff--;
        }
        while(cur1 != null && cur2!= null){
            if(cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
        return cur1;
    }
    public int lenOfNode(ListNode head){
        if(head == null){
            return 0;
        }
        int count = 0;
        ListNode cur = head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
}
