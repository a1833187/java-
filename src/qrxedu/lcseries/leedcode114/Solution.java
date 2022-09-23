package qrxedu.lcseries.leedcode114;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    private List<TreeNode> l = new ArrayList<>();
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode p = null;
        dfs(root);
        p =dfs1(0);

    }
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        l.add(root);
        dfs(root.left);
        dfs(root.right);
    }
    private TreeNode dfs1(int index){
        if(index == l.size()){
            return null;
        }
        TreeNode p = l.get(index);
        p.left = null;
        p.right = dfs1(index+1);
        return p;
    }
    @Test
    public void show(){
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(5);
        TreeNode r4 = new TreeNode(3);
        TreeNode r5 = new TreeNode(4);
        TreeNode r6 = new TreeNode(6);
        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;
        flatten(r1);
    }
}
