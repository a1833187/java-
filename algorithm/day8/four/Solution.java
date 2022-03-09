package qrxedu.algorithm.day8.four;

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
    public int heightOfTree(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(heightOfTree(root.left),heightOfTree(root.right)) + 1;
    }
}
