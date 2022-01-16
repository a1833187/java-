package com.qrxedu.lcseries.leetcode677;

/**
 *实现一个 MapSum 类，支持两个方法，insert和sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。
 * 如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 */
public class MapSum {

    public Node head;
    public Node last;

    public MapSum() {
    }

    public void insert(String key, int val) {
        Node n = new Node(key, val);
        if (head == null) {
            head = n;
            last = n;
        }
        Node cur = head;
        while (cur != null) {
            if (cur.key.equals(key)) {
                cur.val = val;
                break;
            }
            cur = cur.next;
        }
        if (cur == null) {
            last.next = n;
            last = n;
        }
    }

    public int sum(String prefix) {
        int sum = 0;
        Node cur = head;
        while (cur != null) {
            int count = 0;
            if (prefix.length() <= cur.key.length()) {
                for (int i = 0; i < prefix.length(); i++) {
                    if (prefix.charAt(i) == cur.key.charAt(i)) {
                        count++;
                        if (count == prefix.length()) {
                            sum += cur.val;
                        }
                    } else {
                        break;
                    }
                }
                count = 0;
            }
            cur = cur.next;
        }
        return sum;
    }
}
