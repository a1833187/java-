package qrxedu.offer;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer54 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public int val = 0;
    public int k;
    public int kthLargest(TreeNode root, int _k) {
        k = _k;
        dfs(root);
        return val;
    }
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }

        dfs(root.right);
        k--;
        if(k == 0){
            val = root.val;
            return;
        }
        dfs(root.left);
    }
    @Test
    public void show(){
        TreeNode r = new TreeNode(5);
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(6);
        TreeNode r3 = new TreeNode(2);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(1);
        r.left = r1;
        r.right = r2;
        r1.left = r3;
        r1.right = r4;
        r3.left = r5;
        System.out.println(kthLargest(r,3));
    }
}

