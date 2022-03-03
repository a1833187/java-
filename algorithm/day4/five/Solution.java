package qrxedu.algorithm.day4.five;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    public Node deleteDuplication(Node head){
        if(head == null){
            return null;
        }
        Node dummy = new Node(-1);
        Node pre = dummy;
        Node cur = head;
        if(cur.next != null && cur.val == cur.next.val){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            cur = cur.next;
        }else{
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}
