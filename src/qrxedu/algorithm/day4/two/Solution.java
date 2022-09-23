package qrxedu.algorithm.day4.two;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    class Node{
        public int val;
        public Node next;
        public Node(int val){
            this.val = val;
        }
    }
    public Node listOfMerge(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return head1 == null ? head2 : head1;
        }
        Node newHead = new Node(-1);
        Node cur = newHead;
        Node cur1 = head1;
        Node cur2 = head2;
        //这个循环也可以写成递归的形式：
        /*
             if(cur1.val < cur2.val){
                cur.next = cur1;
                cur = cur1;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur = cur2;
                cur2 = cur2.next;
            }
            cur.next = listOfMerge(cur1,cur2);
         */
        while(cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                cur.next = cur1;
                cur = cur1;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur = cur2;
                cur2 = cur2.next;
            }
        }
        cur.next = cur1 == null? cur2 : cur1;
        return newHead.next;
    }
}
