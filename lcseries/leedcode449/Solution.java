package qrxedu.leedcode449;

import java.util.*;

/**
 * 二叉搜索书的序列化和反序列化:
 * 序列化:先序,后序都可
 * 反序列化:先序,因为是从字符串到二叉树,需要先根遍历
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public class Codec {
        public String serialize(TreeNode root) {
            List<Integer> list = new ArrayList<Integer>();
            postOrder(root, list);
            String str = list.toString();
            return str.substring(1, str.length() - 1);
        }

        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] arr = data.split(", ");
            Deque<Integer> stack = new ArrayDeque<Integer>();
            int length = arr.length;
            for (int i = 0; i < length; i++) {
                stack.push(Integer.parseInt(arr[i]));
            }
            return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
        }

        private void postOrder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            postOrder(root.left, list);
            postOrder(root.right, list);
            list.add(root.val);
        }

        private TreeNode construct(int lower, int upper, Deque<Integer> stack) {
            //哇,这个很秀.通过锁定一个节点的值的大小来判断是否为空值.
            //比如2-1-null.   root.right =construct(2,MAX,stack),此时stack的peek是1小于2,说明右节点为空
            if (stack.isEmpty() || stack.peek() < lower || stack.peek() > upper) {
                return null;
            }
            int val = stack.pop();
            TreeNode root = new TreeNode(val);
            root.right = construct(val, upper, stack);
            root.left = construct(lower, val, stack);
            return root;
        }
    }
}
