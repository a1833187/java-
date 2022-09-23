package qrxedu.algorithm.day10.three;

import java.util.Stack;

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
    public TreeNode kthTreeNode(TreeNode root,int k){
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty()||cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                k--;
                if(k == 0){
                    return cur;
                }
                cur = cur.right;
            }
        }
        return null;
    }
}
