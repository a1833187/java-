package qrxedu.lcseries.leedcode337;

import java.util.*;

/**
 * 打家劫舍：树形dp：在节点的左树上是一个状态，右树上是另一个状态，
 * 状态的总数不定，但状态之间一定是相互影响的
 * 动规的状态方程由两个方程组成，两个方程相互影响
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
        Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
        Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

        public int rob(TreeNode root) {
            dfs(root);
            return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
        }

        public void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            dfs(node.left);
            dfs(node.right);
            f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
            g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
        }
    }
