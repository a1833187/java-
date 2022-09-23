package qrxedu.lcseries.leedcode113;

import org.junit.jupiter.api.Test;

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<Integer> cur = new ArrayList<>();
        pathSum(root,targetSum,list,cur);
        return list;
    }
    private void pathSum(TreeNode root,int targetSum,List<List<Integer>> res,List<Integer> cur){
        if(root == null){
            return;
        }
        targetSum-=root.val;
        cur.add(root.val);
        if(root.left == null && root.right == null && targetSum == 0){
            List<Integer> list1 = new ArrayList<>(cur);
            res.add(list1);
        }
        pathSum(root.left,targetSum,res,cur);
        pathSum(root.right,targetSum,res,cur);
        cur.remove(cur.size()-1);
    }
    @Test
    public void show(){
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(2);
        t1.left = t2;
        t2.left = t3;
        t1.right = t4;
        t4.right = t5;
        System.out.println(pathSum(t1,8));
    }
}
