package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer73 {
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
        if(root.val > p.val && root.val < q.val || root.val > q.val && root.val < p.val){
            return root;
        }else if(root.val == p.val || root.val == q.val){
            return root;
        }else if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else{
            return lowestCommonAncestor(root.right,p,q);
        }
    }
}
