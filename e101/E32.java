package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E32 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val){
            this.val = val;
        }
    }
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        // write code here
        TreeNode root = new TreeNode(0);
        if(t1 == null && t2 == null){
            root = null;
            return root;
        }
        root.val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        root.left = mergeTrees(t1 == null ? null : t1.left,t2 == null ? null : t2.left);
        root.right = mergeTrees(t1 == null ? null : t1.right,t2 == null ? null : t2.right);
        return root;
    }
}
