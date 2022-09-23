package qrxedu.e101;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E30 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val){
            this.val = val;
        }
    }
    TreeNode prev = null;
    public TreeNode Convert(TreeNode root) {
        if(root == null){
            return root;
        }
        dfs(root);
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }

        dfs(root.left);
        root.left = prev;
        if(prev != null){
            prev.right = root;
        }
        prev = root;
        dfs(root.right);
    }
    @Test
    public void show(){
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(14);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(8);
        TreeNode t6 = new TreeNode(12);
        TreeNode t7 = new TreeNode(16);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        System.out.println(Convert(t1));
    }
}
