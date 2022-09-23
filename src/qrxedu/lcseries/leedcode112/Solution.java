package qrxedu.lcseries.leedcode112;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    int count = 0;
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        count+=root.val;
        hasPath(root,targetSum);
        return flag;
    }
    public void hasPath(TreeNode root, int targetNum){
        if(root == null){
            return;
        }
        if(root.left != null){
            count+=root.left.val;
            hasPath(root.left,targetNum);
        }
        if(root.right != null){
            count+=root.right.val;
            hasPath(root.right,targetNum);
        }
        if(root.left == null && root.right == null && count == targetNum){
            flag = true;
            return;
        }
        count -= root.val;
    }
}
