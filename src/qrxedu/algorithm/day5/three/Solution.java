package qrxedu.algorithm.day5.three;

import java.util.LinkedList;
import java.util.Queue;

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
    public void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right != null){
                queue.offer(cur.right);
            }
        }
    }
}
