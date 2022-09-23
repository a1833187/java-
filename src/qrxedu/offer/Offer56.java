package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer56 {
    public boolean flag = true;
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val){
            this.val = val;
        }
    }
    public boolean isBalanced(TreeNode root) {
        getLenth(root);
        return flag;
    }
    public int getLenth(TreeNode root){
        if(!flag){
            return -1;
        }
        if(root == null){
            return 0;
        }
        int leftL = getLenth(root.left) + 1;
        int rightL = getLenth(root.right) + 1;
        if(Math.abs(leftL-rightL) > 1){
            flag = false;
            return -1;
        }else{
            return Math.max(leftL,rightL);
        }
    }
}
