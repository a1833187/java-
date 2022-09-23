package qrxedu.algorithm.day10.two;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public List<List<Integer>> print(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 1;
        if(root == null){
            return list;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list1 = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if(count == 1){
                count = 0;
                while(size > 0){
                    TreeNode cur = queue.poll();
                    list1.add(cur.val);
                    if(cur.left != null){
                        queue.offer(cur.left);
                    }
                    if(cur.right != null){
                        queue.offer(cur.right);
                    }
                    size--;
                }
            }else{
                count = 1;
                while(size > 0){
                    TreeNode cur = queue.poll();
                    stack.add(cur);
                    if(cur.left != null){
                        queue.offer(cur.left);
                    }
                    if(cur.right != null){
                        queue.offer(cur.right);
                    }
                    size--;
                }
            }
            if (!stack.empty()) {
                while (!stack.empty()) {
                    list1.add(stack.pop().val);
                }
            }
            list.add(list1);
        }
        return list;
    }
}
