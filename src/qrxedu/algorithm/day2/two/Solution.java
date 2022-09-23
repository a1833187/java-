package qrxedu.algorithm.day2.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Node> reverseLinkedList1(Node head){
        //用栈顺序存储链表节点然后从栈顶依次弹出
        if(head == null){
            return null;
        }
        List<Node> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(!stack.empty()){
            list.add(stack.pop());
        }
        return list;
    }
    public List<Node> reverseLinkedList2(Node head){
        //递归逆置链表
        if(head == null){
            return null;
        }
        List<Node> list = new ArrayList<>();
        Node cur = head;
        reverse(list,cur);
        return list;
    }
    private void reverse(List<Node> list,Node head){
        if(head == null){
            return;
        }
        reverse(list,head.next);
        list.add(head);
    }
}
