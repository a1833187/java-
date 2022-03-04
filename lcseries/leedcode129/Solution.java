package qrxedu.leedcode129;

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
    public int count = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        sumNumbers(root,list);
        return count;
    }
    private void sumNumbers(TreeNode root,List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left == null && root.right == null){
            for(int i = 0; i < list.size(); i++){
                count+=list.get(i)*(int)(Math.pow(10,list.size()-1-i));
            }
        }
        sumNumbers(root.left,list);
        sumNumbers(root.right,list);
        list.remove(list.size()-1);
    }
}
