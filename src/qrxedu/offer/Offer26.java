package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer26 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null && B == null){
            return true;
        }else if((A == null || B == null)){
            return false;
        }
        if(isSameTree(A,B)){
            return true;
        }
        return isSubStructure(A.left,B) || isSubStructure(A.right,B);

    }
    public boolean isSameTree(TreeNode A,TreeNode B){
        if(B == null){
            return true;
        }else if((A == null || B == null)){
            return false;
        }
        if(A.val != B.val){
            return false;
        }
        return isSameTree(A.left,B.left) && isSameTree(A.right,B.right);
    }
}
