package qrxedu.algorithm.day4.three;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public boolean hasSubTree(TreeNode rootA,TreeNode rootB){
        if(rootA == null || rootB == null){
            return false;
        }
        if(isSameTree(rootA,rootB)){
            return true;
        }else{
            return hasSubTree(rootA.left,rootB) || hasSubTree(rootA.right,rootB);
        }
    }
    public boolean isSameTree(TreeNode rootA,TreeNode rootB){
        if(rootA == null && rootB == null){
            return true;
        }else if(rootA == null || rootB == null){
            return false;
        }else if(rootA.val != rootB.val){
            return false;
        }else{
            boolean leftT = isSameTree(rootA.left,rootB.left);
            boolean rightT = isSameTree(rootA.right,rootB.right);
            return leftT && rightT;
        }
    }
}
