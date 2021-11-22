package com.qrxedu.leedcode725;

import java.awt.*;

/**
 * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 * 返回一个由上述 k 部分组成的数组。
 * 特例:
 * head = [1,2,3], k = 5
 * [[1],[2],[3],[],[]]
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        int a = 0;
        ListNode[] lists = new ListNode[k];
        if(head == null){
            return lists;
        }
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        cur = head;
        int num = len/k;
        int r = len%k;
        if(num == 0){
            while(cur != null){
                ListNode curNext = cur.next;
                cur.next = null;
                lists[a++] = cur;
                cur = curNext;
            }
        }else{
            ListNode tmp = head;
            ListNode newHead = head;
            ListNode tmp1 = head;
            if(r!=0){
                while(r>0){
                    for(int i = 1; i < num + 1; i++){
                        tmp = tmp.next;
                    }
                    tmp1 = tmp.next;
                    tmp.next = null;
                    lists[a++] = newHead;
                    newHead = tmp1;
                    tmp = tmp1;
                    r--;
                }
                while(tmp != null){
                    for(int i = 1; i < num; i++){
                        tmp = tmp.next;
                    }
                    tmp1 = tmp.next;
                    tmp.next = null;
                    lists[a++] = newHead;
                    newHead = tmp1;
                    tmp = tmp1;
                }
            }else{
                while(tmp != null){
                    for(int i = 1; i < num; i++){
                        tmp = tmp.next;
                    }
                    tmp1 = tmp.next;
                    tmp.next = null;
                    lists[a++] = newHead;
                    newHead = tmp1;
                    tmp = tmp1;
                }
            }
        }
        return lists;
    }
}
