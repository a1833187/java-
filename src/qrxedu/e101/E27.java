package qrxedu.e101;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E27 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer> > ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int k = 0;
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> l = new ArrayList<>();
            Deque<Integer> d = new LinkedList<>();
            while(size != 0){
                TreeNode cur = q.poll();
                if(k % 2 != 0){
                    d.push(cur.val);
                }else{
                    l.add(cur.val);
                }
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                size--;
            }
            if(k % 2 != 0){
                int n = d.size();
                for(int i = 0; i < n; i++){
                    l.add(d.pop());
                }
            }
            ans.add(l);
            k++;
        }
        return ans;
    }
}
