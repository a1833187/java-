package qrxedu.lcseries.leedcodeo06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int k = 0;
        int[] res = new int[list.size()];
        for(int i = res.length-1;i>=0;i--){
            res[i] = list.get(k);
            k++;
        }
        return res;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
