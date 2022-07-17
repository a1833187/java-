package qrxedu.e101;

import java.util.Arrays;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E12 {
    static class ListNode{
        int val;
        ListNode next;
        ListNode (int val){
            this.val = val;
        }
    }

    /**
     * 利用归并排序实现单链表的排序
     * 将链表均分成两部分(快慢指针),分别排列这两部分,然后合并两个有序链表
     * @param head
     * @return
     */
    public ListNode sortInList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode l = sortInList(head);
        ListNode r = sortInList(tmp);
        ListNode h = new ListNode(-1);
        ListNode cur = h;
        while(l != null && r != null){
            if(l.val < r.val){
                ListNode node = new ListNode(l.val);
                cur.next = node;
                cur = node;
                l = l.next;
            }else{
                ListNode node = new ListNode(r.val);
                cur.next = node;
                cur = node;
                r = r.next;
            }
        }
        cur.next = l == null ? r : l;
        return h.next;
    }
    public ListNode sortInList1 (ListNode head) {
        // write code here
        if(head == null || head.next == null){
            return head;
        }
        int len = getLength(head);
        int[] arr = new int[len];
        ListNode cur = head;
        int idx = 0;
        while(cur != null){
            arr[idx++] = cur.val;
            cur = cur.next;
        }
        Arrays.sort(arr);
        idx = 0;
        cur = head;
        while(cur != null){
            cur.val = arr[idx++];
            cur = cur.next;
        }
        return head;
    }
    public int getLength(ListNode head){
        if(head == null){
            return 0;
        }
        int len = 1;
        ListNode cur = head;
        while(cur.next != null){
            len++;
            cur = cur.next;
        }
        return len;
    }
}
