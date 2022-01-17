package com.qrxedu.leedcode382;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public ListNode head;
    public int len;
    public Solution(ListNode head1){
       ListNode cur = null;
       while(head1!=null){
           if(head == null){
               head = head1;
               cur = head1;
           }else{
               head.next = head1;
               head = head1;
           }
           len++;
           head1 = head1.next;
       }
       head = cur;
    }
    public int getRandom(){
        int n = (int)(Math.random()*len);
        ListNode cur = head;
        while(n > 0){
            cur = cur.next;
            n--;
        }
        return cur.val;
    }


}
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
