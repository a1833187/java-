package qrxedu.lcseries.leedcode138;

import java.util.HashMap;
import java.util.Map;

/**
 * map 存储原结点和新节点之间的映射关系
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class Node{
        int val;
        Node next;
        Node random;
        public Node(int val){
            this.val = val;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        while(cur != null){
            Node cur1 = new Node(cur.val);
            map.put(cur,cur1);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
    /*
      if(head == null){
            return null;
        }
        Node newHead = new Node(-1);
        Node cur = head;
        Node newCur = newHead;
        while(cur != null){
           Node tmp = new Node(cur.val);
           newCur.next = tmp;
           newCur = tmp;
           cur = cur.next;
        }
        int k = 0;
        cur = head;
        newCur = newHead.next;
        while(cur != null){
            if(cur.random == null){
                newCur.random = null;
                cur = cur.next;
                newCur = newCur.next;
            }else{
                Node temp2 = newHead.next;
                Node temp1 = head;
                int len = 0;
                while(temp1 != cur.random){
                    temp1 = temp1.next;
                    len++;
                }
                for(int i = 0; i < len;i++){
                    temp2 = temp2.next;
                }
                newCur.random = temp2;
                cur = cur.next;
                newCur = newCur.next;
            }
        }
        return newHead.next;
     */
}
