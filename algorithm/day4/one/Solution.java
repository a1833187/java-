package qrxedu.algorithm.day4.one;

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

    /**
     * 三指针反转链表
     * @param head
     * @return
     */
    public Node listOfReverse(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node pre = null;
        Node mid = head;
        Node end = head.next;
        while(end != null){
            mid.next = pre;
            pre = mid;
            mid = end;
            end = end.next;
        }
        //由于是先翻转然后指针后移，所以最后一次指针后移需要单独处理
        mid.next = pre;
        return mid;
    }

    /**
     * 头插法反转链表
     * @param head
     * @return
     */
    public Node listOfReverse1(Node head){
        if(head == null){
            return head;
        }
        Node newHead = new Node(-1);
        Node cur = head;
        while(cur != null){
            if(newHead.next == null){
                newHead.next = cur;
            }else{
                cur.next = newHead.next;
                newHead.next = cur;
            }
            cur = cur.next;
        }
        return newHead.next;
    }
}
