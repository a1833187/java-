package qrxedu.algorithm.day4.four;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public void mirror(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        mirror(root.left);
        mirror(root.right);
    }
}
