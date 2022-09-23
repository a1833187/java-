package qrxedu.lcseries.leedcode965;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public boolean isUnivalTree(TreeNode root) {
        int val = root.val;
        Boolean[] flag = new Boolean[1];
        flag[0] = true;
        dfs(root, flag, val);
        return flag[0];
    }

    public void dfs(TreeNode root, Boolean[] flag, int val) {
        if (root == null) {
            return;
        }
        if (root.val != val) {
            flag[0] = false;
            return;
        }
        dfs(root.left, flag, val);
        dfs(root.right, flag, val);
    }
    @Test
    public void show(){
        TreeNode root = new TreeNode(2);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(5);
        TreeNode root4 = new TreeNode(2);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        System.out.println(isUnivalTree(root));
    }
}
