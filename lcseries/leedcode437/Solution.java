package qrxedu.lcseries.leedcode437;

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
        TreeNode(int val){
            this.val = val;
        }
    }
    int ans = 0;
    List<TreeNode> cache = new ArrayList<>();
    public int pathSum(TreeNode root, int targetSum) {
        preOrder(root);
        long target = targetSum;
        for(TreeNode p : cache){
            dfs(p,target);
        }
        return ans;
    }
    private void preOrder(TreeNode p){
        if(p == null){
            return;
        }
        cache.add(p);
        preOrder(p.left);
        preOrder(p.right);
    }
    private void dfs(TreeNode p,long target){
        if(p == null){
            return;
        }
        if(target == p.val){
            ans++;
        }
        dfs(p.left,target-p.val);
        dfs(p.right,target-p.val);
    }
    @Test
    public void show(){
        TreeNode r1 = new TreeNode(10);
        TreeNode r2 = new TreeNode(5);
        TreeNode r3 = new TreeNode(-3);
        TreeNode r4 = new TreeNode(3);
        TreeNode r5 = new TreeNode(2);
        TreeNode r6 = new TreeNode(11);
        TreeNode r7 = new TreeNode(3);
        TreeNode r8 = new TreeNode(2);
        TreeNode r9 = new TreeNode(1);
        r1.left = r2;
        r1.right = r3;
        r2.left = r4;
        r2.right = r5;
        r3.right = r6;
        r4.left = r7;
        r4.right = r8;
        r5.right = r9;
        System.out.println(pathSum(r1,8));
    }
}
