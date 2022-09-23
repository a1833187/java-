package qrxedu.lcseries.leedcode653;

import java.util.HashSet;
import java.util.Set;

/**
 * BST两数之和
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
   static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        if(set.contains(k-root.val)){
            return true;
        }
        set.add(root.val);
        return findTarget(root.left,k) || findTarget(root.right,k);

    }
}
