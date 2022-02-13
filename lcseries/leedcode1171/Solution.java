package qrxedu.leedcode1171;

import java.util.HashMap;

/**
 * 删去链表中总和值为0的所有连续结点
 * 思路：两次hashMap遍历，根据数列，一个序列中如果存在某个子序列的和为0，
 * 则在该序列的前缀和序列当中，该子序列的前一个元素的前缀和和该子序列中最后一个元素的前缀和相同
 * 如 1，3，-3，4 === >   1，4，1，5
 * 根据此我们可以利用hashMap中只存放非重复的元素，将相同的前缀和的最后一个位置记录下来，
 * 然后再次遍历即可，需要注意的是我们需要一个值为0的前缀指针来考虑第一个结点是否是待删除结点的情况。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeZeroSumSubLists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int sum = 0;
        HashMap<Integer,ListNode> hashMap = new HashMap<>();
        for(ListNode d = dummy; d != null; d = d.next){
            sum += d.val;
            hashMap.put(sum,d);
        }
        sum = 0;
        for(ListNode d = dummy; d != null; d = d.next){
            sum+=d.val;
            d.next = hashMap.get(sum).next;
        }
        return dummy.next;
    }

}
