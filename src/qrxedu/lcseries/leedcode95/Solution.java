package qrxedu.lcseries.leedcode95;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> tree = new ArrayList<>();
        tree = generateTrees(1,n);
        return tree;
    }
   public List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            list.add(null);
            return list;
        }
        for(int i = start;i<=end;i++){
            List<TreeNode> leftTree = generateTrees(start,i-1);
            List<TreeNode> rightTree = generateTrees(i+1,end);
            for(TreeNode l:leftTree){
                for(TreeNode r:rightTree){
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    list.add(cur);
                }
            }
        }
        return list;
   }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}