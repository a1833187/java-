package qrxedu.e101;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E25 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public int[] postorderTraversal (TreeNode root) {
        // write code here
        List<Integer> l = new ArrayList<>();
        postOrder(root,l);
        int n = l.size();
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = l.get(i);
        }
        return ans;
    }
    public void postOrder(TreeNode root,List<Integer> l){
        if(root == null){
            return;
        }
        postOrder(root.left,l);
        postOrder(root.right,l);
        l.add(root.val);
    }
}
