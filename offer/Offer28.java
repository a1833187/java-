package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer28 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return func(root,root);
    }
    public boolean func(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 == null || root2 == null){
            return false;
        }
        if(root1.val != root2.val){
            return false;
        }
        return func(root1.left,root2.right) && func(root1.right,root2.left);
    }
}
