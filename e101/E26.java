package qrxedu.e101;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E26 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> curL = new ArrayList<>();
            while(size != 0){
                TreeNode cur = q.poll();
                curL.add(cur.val);
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                size--;
            }
            ans.add(curL);
        }
        return ans;
    }
}
