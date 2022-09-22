package qrxedu.lcseries.leedcode124;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode p){
        if(p == null){
            return 0;
        }

        int leftA = Math.max(dfs(p.left),0);
        int rightA = Math.max(dfs(p.right),0);

        ans = Math.max(ans,leftA+rightA+p.val);
        return p.val + Math.max(leftA,rightA);
    }
}
