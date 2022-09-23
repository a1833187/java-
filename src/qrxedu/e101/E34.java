package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E34 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public int min = Integer.MAX_VALUE;
    public int max = Integer.MIN_VALUE;
    public boolean isValidBST (TreeNode root) {
        // write code here
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        max = root.left == null ? Integer.MIN_VALUE : root.left.val;
        min = root.right == null ? Integer.MAX_VALUE : root.right.val;
        getMin(root.left,'l');
        getMin(root.right,'r');
        if(root.val >= min || root.val <= max){
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public void getMin(TreeNode root,char ch){
        if(root == null){
            return;
        }
        if(ch == 'l'){
            if(root.val > max){
                max = root.val;
            }
        }else{
            if(root.val < min){
                min = root.val;
            }
        }
        getMin(root.left,ch);
        getMin(root.right,ch);
    }
}
