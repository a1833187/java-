package qrxedu.lcseries.leedcode94;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> inOrderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            inOrderTraversal(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inOrderTraversal(root.right);
        }
        return list;
    }

}
