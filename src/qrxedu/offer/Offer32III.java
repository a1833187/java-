package qrxedu.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer32III {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val){
            this.val = val;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Queue<TreeNode> q = new LinkedList<>();
        int flag = 1;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            while(size != 0){
                TreeNode cur = q.poll();
                l.add(cur.val);
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                size--;
            }
            if(flag % 2 == 0){
                reverse(l);
            }
            flag++;
            list.add(l);
        }
        return list;
    }
    public void reverse(List<Integer> list){
        int n = list.size();
        int l = 0,r = n-1;
        while(l < r){
            int tmp = list.get(l);
            list.set(l,list.get(r));
            list.set(r,tmp);
            l++;
            r--;
        }
    }
}
