package qrxedu.leedcode0201;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * 移除未排序链表中的重复元素，且不能改变链表的顺序
 * 思路：利用hashSet结构存储的元素不能重复的特点，根据hashSet的长度是否发生变化来决定是否是重复元素
 * 然后利用双指针去掉重复的元素
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null){
            return null;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        ListNode cur = head;
        ListNode prev = null;
        int count = 0;
        while(cur != null){
            hashSet.add(cur.val);
            if(count == hashSet.size()){
                if(prev != null){
                    prev.next = cur.next;
                    cur = cur.next;
                }
            }else{
                prev = cur;
                cur = cur.next;
            }
            count = hashSet.size();

        }
        return head;

    }
    @Test
    public void show(){
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(2);
        ListNode head5 = new ListNode(1);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        removeDuplicateNodes(head);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
