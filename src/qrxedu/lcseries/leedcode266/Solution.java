package qrxedu.lcseries.leedcode266;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class TreeNode1{
        public int val;
        public TreeNode1 left;
        public TreeNode1 right;
        public TreeNode1(int val){
            this.val = val;
        }
    }
    public TreeNode1 invertTree(TreeNode1 root) {
        if(root == null) {
            return null;
        }
        invertTreeC(root);
        return root;
    }
    private void invertTreeC(TreeNode1 root){
        if(root == null){
            return;
        }
        TreeNode1 tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTreeC(root.left);
        invertTreeC(root.right);
    }
}
