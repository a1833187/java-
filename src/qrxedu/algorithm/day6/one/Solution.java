package qrxedu.algorithm.day6.one;

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

    public List<List<Integer>> findPath(TreeNode root, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        List<Integer> cur = new ArrayList<>();
        findPath(root,target,list,cur);
        return list;
    }

    private void findPath(TreeNode root, int target, List<List<Integer>> res, List<Integer> cur) {
        if (root == null) {
            return;
        }
        cur.add(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            //这里需要重新拷贝一个列表，因为引用会导致删除的是同一个列表，即使已经存储到这。
            List<Integer> list1 = new ArrayList<>(cur);
            res.add(list1);
        }
        findPath(root.left, target, res, cur);
        findPath(root.right, target, res, cur);
        cur.remove(cur.size()-1);
    }
}
