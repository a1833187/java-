package qrxedu.lcseries.leedcode98;

/**
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

    /**
     * 验证一颗树是否为二叉搜索树
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isChildLeftTree(root, root.left) || !isChildRightTree(root, root.right)) {
            return false;
        } else {
            return isValidBST(root.left) && isValidBST(root.right);
        }
    }

    /**
     * 判断一棵二叉树的左树的节点是否合理
     * @param root
     * @param child
     * @return
     */
    public boolean isChildLeftTree(TreeNode root, TreeNode child){
        if(child == null){
            return true;
        }
        if(child.val >= root.val){
            return false;
        }else{
            return isChildLeftTree(root,child.left) && isChildLeftTree(root,child.right);
        }
    }

    /**
     * 判断一棵二叉树的右树的节点是否合理
     * @param root
     * @param child
     * @return
     */
    public boolean isChildRightTree(TreeNode root, TreeNode child){
        if(child == null){
            return true;
        }
        if(child.val <= root.val){
            return false;
        }else{
            return isChildRightTree(root,child.left) && isChildRightTree(root,child.right);
        }
    }
}
