package qrxedu.e101;

import java.util.ArrayList;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E5 {
    static class ListNode{
        int val;
       ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ListNode cur1 = new ListNode(list1.val);
                cur.next = cur1;
                cur = cur1;
                list1 = list1.next;
            }else{
                ListNode cur2 = new ListNode(list2.val);
                cur.next = cur2;
                cur = cur2;
                list2 = list2.next;
            }
        }
        cur.next = list1 == null ? list2 : list1;
        return dummy.next;

    }
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        int n = lists.size();
        if(lists == null || n == 0){
            return null;
        }
        if(n == 1){
            return lists.get(0);
        }
        while(n != 1){
            int k = 0;
            int idx = 0;
            if(n % 2 != 0){
                lists.set(0,Merge(lists.get(0),lists.get(n-1)));
                n--;
            }
            for(; k < n; k+= 2){
                lists.set(idx++,Merge(lists.get(k),lists.get(k+1)));
            }
            n = k / 2;
        }
        return lists.get(0);
    }
}
