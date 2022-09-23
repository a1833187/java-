package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E31 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null){
            return true;
        }
        return isV(pRoot.left,pRoot.right);
    }
    boolean isV(TreeNode r1,TreeNode r2){
        if(r1 == null && r2 == null){
            return true;
        }
        if(r1 == null || r2 == null){
            return false;
        }
        if(r1.val != r2.val){
            return false;
        }
        return isV(r1.left,r2.right) && isV(r1.right,r2.left);
    }
}
