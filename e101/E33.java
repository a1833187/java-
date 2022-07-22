package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E33 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val){
            this.val = val;
        }
    }
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot == null){
            return null;
        }
        TreeNode root = new TreeNode(pRoot.val);
        root.left = Mirror(pRoot.right);
        root.right = Mirror(pRoot.left);;
        return root;
    }
}
