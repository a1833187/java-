package qrxedu.e101;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E24 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public int[] inorderTraversal (TreeNode root) {
        // write code here
        List<Integer> l = new ArrayList<>();
        inOrder(root,l);
        int n = l.size();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = l.get(i);
        }
        return ans;

    }
    public void inOrder(TreeNode root,List<Integer> l){
        if(root == null){
            return;
        }
        inOrder(root.left,l);
        l.add(root.val);
        inOrder(root.right,l);
    }
}
