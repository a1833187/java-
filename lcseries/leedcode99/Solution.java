package qrxedu.leedcode99;

import java.util.Stack;

/**
 * 恢复二叉搜索树：题目保证交换该二叉树的两个结点的值一定可以保证形成二叉搜索树
 * 对于一个递增序列而言，交换两个节点i,j(i<j)的值会导致:
 * a(i)>a(i+1) a(j-1)>a(j) || a(i) > a(j)
 * 如何找到这两个值:
 * 1.顺序遍历，"永久"保留第一个不满足递增规律的较大值,"暂时"保留第一个不满足递增规律的较小值;
 * 2.继续遍历,如果又一次遇见不满足递增规律的情况，更新较小值。
 * 3.遍历结束，保留的两个值即为交换的两个数据
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
    TreeNode prev = null;
    TreeNode x = null;
    TreeNode y = null;
    Stack<TreeNode> stack = new Stack<>();
    public void recoverTree(TreeNode root) {
        while(!stack.empty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev != null && root.val < prev.val){
                y = root;
                if(x == null){
                    x = prev;
                }else{
                    break;
                }
            }
            prev = root;
            root = root.right;
        }
        swap(x,y);
    }
    public void swap(TreeNode node1,TreeNode node2){
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }

}
