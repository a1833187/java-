package qrxedu.lcseries.leedcode111;

/**
 * 求二叉树的最小深度
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }else if(root.left == null){
            return minDepth(root.right) + 1;
        }else if(root.right == null){
            return minDepth(root.left) + 1;
        }else{
            return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
        }
    }
}
