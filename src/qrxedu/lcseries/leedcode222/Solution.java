package qrxedu.lcseries.leedcode222;

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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
