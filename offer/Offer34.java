package qrxedu.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer34 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public List<List<Integer>> list = new ArrayList<>();
    public List<Integer> cur = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null){
            return list;
        }
        dfs(root,target);
        return list;
    }
    public void dfs(TreeNode root,int t){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(t == root.val){
                List<Integer> tmp = new ArrayList<>(cur);
                tmp.add(root.val);
                list.add(tmp);
            }
            return;
        }
        cur.add(root.val);
        dfs(root.left,t-root.val);
        dfs(root.right,t-root.val);
        cur.remove(cur.size()-1);
    }

}
