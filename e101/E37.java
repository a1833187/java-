package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E37 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // write code here
        if(root.val > p && root.val < q || root.val > q && root.val < p){
            return root.val;
        }
        if(root.val > p && root.val > q){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val < p && root.val < q){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root.val;
    }
}
