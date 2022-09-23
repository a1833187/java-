package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * K个一组翻转链表
 * @author qiu
 * @version 1.8.0
 */
public class E3 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode reverseKGroup (ListNode head, int k) {
        // write code here
        if(head == null || head.next == null){
            return head;
        }
        List<ListNode[]> l = new ArrayList<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode pro = head.next;
        int len = getLength(head);
        int j = 0;
        if(len < k){
            return head;
        }
        while(j < len / k){
            ListNode pre = cur;
            for(int i = 0; i < k - 1; i++){
                ListNode newPro = pro.next;
                pro.next = cur;
                cur = pro;
                pro = newPro;
            }
            j++;
            ListNode[] curL = new ListNode[2];
            curL[0] = cur;
            curL[1] = pre;
            l.add(curL);
            cur = pro;
            if(pro != null){
                pro = pro.next;
            }
        }
        for(int i = 0; i < l.size()-1;i++){
            l.get(i)[1].next = l.get(i+1)[0];
        }
        l.get(l.size()-1)[1].next = cur;
       // l.get(l.size()-1)[1].next = null;
        return l.get(0)[0];
    }
    public int getLength(ListNode head){
        if(head == null){
            return 0;
        }
        int len = 1;
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
            len++;
        }
        return len;
    }
    @Test
    public void show(){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(reverseKGroup(l1,3));
    }
}
