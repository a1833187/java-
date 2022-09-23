package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer74 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val){
            this.val = val;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        if(l != null && r != null){
            return root;
        }else if(l == null){
            return r;
        }else{
            return l;
        }
    }
}
