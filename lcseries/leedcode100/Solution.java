package com.qrxedu.lcseries.leedcode100;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null || q== null){
            return false;
        }else if(p.val!=q.val){
            return false;
        }else{
            boolean leftT = isSameTree(p.left,q.left);
            boolean rightT = isSameTree(p.right,q.right);
            return leftT && rightT;
        }
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}


