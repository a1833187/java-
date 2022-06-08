package qrxedu.offer;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer18 {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null){
            if(cur.val == val){
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        if(prev == null){
            return head.next;
        }
        prev.next = cur.next;
        return head;
    }
    @Test
    public void show(){
        int MOD = (int)(1e9+7);
        long a = (long)1e8;
        long b= (long)1e8;
        System.out.println((a*b));
        System.out.println((a*b)%MOD);
        System.out.println(((a%MOD)*(b%MOD))%MOD);
    }
}
