package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E35 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val){
            this.val = val;
        }
    }
    public boolean isCompleteTree (TreeNode root) {
        // write code here
        if(root == null){
            return true;
        }

        List<List<TreeNode> > a = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode> curL = new ArrayList<>();
            while(size != 0){
                TreeNode cur = q.poll();
                curL.add(cur);
                if(cur != null){
                    q.offer(cur.left);
                    q.offer(cur.right);
                }
                size--;
            }
            a.add(curL);
        }
        for(int i = 0; i < a.size()-2; i++){
            List<TreeNode> cur = a.get(i);
            for(int j = 0; j < cur.size(); j++){
                if(cur.get(j) == null){
                    return false;
                }
            }
        }
        List<TreeNode> c = a.get(a.size()-2);
        for(int i = 0; i < c.size(); i++){
            if(c.get(i) == null){
                for(int j = i + 1; j < c.size(); j++){
                    if(c.get(j) != null){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    @Test
    public void show(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        System.out.println(isCompleteTree(t1));
    }
}
