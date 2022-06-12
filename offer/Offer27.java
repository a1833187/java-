package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer27 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode r = new TreeNode(root.val);
        r.left = mirrorTree(root.right);
        r.right = mirrorTree(root.left);
        return r;
    }
}
