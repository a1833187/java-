package qrxedu.leedcode266;

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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        invertTreeC(root);
        return root;
    }
    private void invertTreeC(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTreeC(root.left);
        invertTreeC(root.right);
    }
}
