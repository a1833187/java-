package qrxedu.e101;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E23 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public int[] preorderTraversal (TreeNode root) {
        // write code here
        List<Integer> l = new ArrayList<>();
        preOrder(root,l);
        int n = l.size();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
    public void preOrder(TreeNode root,List<Integer> l){
        if(root == null){
            return;
        }
        l.add(root.val);
        preOrder(root.left,l);
        preOrder(root.right,l);
    }
}
