package qrxedu.lcseries.leedcode538;

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
        TreeNode (int val){
            this.val = val;
        }
    }
    List<TreeNode> cache = new ArrayList<>();
    public TreeNode convertBST(TreeNode root) {
        if(root == null){
            return null;
        }
        int n = cache.size();
       int[] sum = new int[n];
       sum[n-1] = cache.get(n-1).val;
       for(int i = n-2; i >= 0; i--){
           sum[i] = sum[i+1] + cache.get(i).val;
           cache.get(i).val = sum[i];
       }
       return root;
    }
    private void dfs(TreeNode p){
        if(p == null){
            return;
        }
        dfs(p.left);
        cache.add(p);
        dfs(p.right);

    }
    @Test
    public void show(){
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(0);
        TreeNode r3 = new TreeNode(2);
        r1.left = r2;
        r1.right = r3;
        convertBST(r1);
    }
}
