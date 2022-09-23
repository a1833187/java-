package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E28 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public int maxDepth (TreeNode root) {
        // write code here
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))  + 1;
    }
}
