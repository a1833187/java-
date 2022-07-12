package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer52 {
    static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        ListNode curA = headA;
        ListNode curB = headB;
        if(lenA < lenB){
            int diff = lenB - lenA;
            while(diff != 0){
                curB = curB.next;
                diff--;
            }
        }else{
            int diff = lenA - lenB;
            while(diff != 0){
                curA = curA.next;
                diff--;
            }
        }
        while(curA != curB){
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
    public int getLen(ListNode head){
        ListNode cur = head;
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        return len;
    }
}
