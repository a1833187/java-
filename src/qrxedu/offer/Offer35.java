package qrxedu.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer35 {
    static class Node{
        int val;
        Node next;
        Node random;
        Node(int val){
            this.val = val;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Map<Node,Node> map = new HashMap<>();
        Node yummy = new Node(-1);
        Node cur = yummy;
        Node cur1 = head;
        while(cur1 != null){
            Node tmp = new Node(cur1.val);
            cur.next = tmp;
            cur = tmp;
            map.put(cur1,tmp);
            cur1 = cur1.next;
        }
        cur = yummy.next;
        cur1 = head;
        while(cur != null){
            if(cur1.random == null){
                cur.random = null;
            }else{
                cur.random = map.get(cur1.random);
            }
            cur1 = cur1.next;
            cur = cur.next;

        }
        return yummy.next;
    }
}
