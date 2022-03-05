package qrxedu.leedcode124;

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
    public int maxPathSum(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        int len = list.size();
        int[] dp = new int[len];
        dp[0] = list.get(0);
        int max = list.get(0);
        for(int i = 1; i < list.size(); i++){
            dp[i] = Math.max(dp[i-1] + list.get(i),list.get(i));
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return max;
    }
    public void inOrder(TreeNode root,List<Integer> list){
        if(root != null && root.left != null){
            inOrder(root.left,list);
        }
        if(root != null) {
            list.add(root.val);
        }
        if(root != null && root.right != null){
            inOrder(root.right,list);
        }

    }
}
