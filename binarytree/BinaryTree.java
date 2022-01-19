package com.qrxedu.binarytree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qiu
 * @version 1.8.0
 */
class BtNode {
    public int val;
    public BtNode left;
    public BtNode right;

    public BtNode(int val) {
        this.val = val;
    }
}

/**
 * 一棵二叉树
 */
public class BinaryTree {
    /**
     * 前序遍历
     *
     * @param root
     */
    public void preOrder(BtNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void midOrder(BtNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        System.out.println(root.val + " ");
        midOrder(root.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(BtNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val + " ");
    }

    /**
     * 子思路求结点个数
     *
     * @param root
     * @return
     */
    public int size(BtNode root) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    int count = 0;

    /**
     * 遍历求结点个数
     *
     * @param root
     * @return
     */
    public int size2(BtNode root) {
        if (root == null) {
            return count;
        }
        count++;
        size2(root.left);
        size2(root.right);
        return count;
    }

    /**
     * 遍历求结点个数
     *
     * @param root
     * @return
     */
    int leafCount = 0;

    public int getLeafNodeCount(BtNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            leafCount++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
        return leafCount;
    }

    /**
     * 子思路求结点个数
     */
    public int getLeafNodeCount2(BtNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right);
    }

    /**
     * 获取第k层结点的个数
     */
    public int getKLevelNodeCount(BtNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        k--;
        return getKLevelNodeCount(root.left, k) + getKLevelNodeCount(root.right, k);
    }

    /**
     * 求树的高度
     * 时间复杂度:O(n)
     * 空间复杂度:O(logn)
     */
    public int getHeight(BtNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    /**
     * 寻找值是否存在
     */
    public BtNode find(BtNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        BtNode leftNode = find(root.left, val);
        if (leftNode != null) {
            return leftNode;
        }
        BtNode rightNode = find(root.right, val);
        if (rightNode != null) {
            return rightNode;
        }
        return null;
    }

    /**
     * 判断一棵树是不是二叉树
     */
    public boolean isCompleteTree(BtNode root) {
        if (root == null) {
            return true;
        }
        Queue<BtNode> queue = new LinkedList<>();
        queue.offer(root);
        BtNode cur;
        while (queue.peek() != null) {
            cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        while (!queue.isEmpty()) {
            cur = queue.peek();
            if (cur != null) {
                break;
            }
            queue.poll();
        }
        return queue.isEmpty();
    }

    /**
     * A B C # # D E # G # # F # # #
     *
     * @param
     * @return
     */
    static int h = 0;

    public BtNode preOrder(String str) {
        BtNode root = null;
        if (str.charAt(h) != '#') {
            root = new BtNode(str.charAt(h));
            h++;
            root.left = preOrder(str);
            root.right = preOrder(str);
        } else {
            h++;
        }
        return root;
    }

    /**
     * 层序遍历
     *
     * @param root
     */
    public void levelOrder(BtNode root) {
        Queue<BtNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        BtNode cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    /**
     * 判断两棵二叉树是否相同(结构相同且每个对应节点的值相同)
     */
    public boolean isTheSameTree(BtNode p, BtNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return isTheSameTree(p.left, q.left) && isTheSameTree(p.right, q.right);
        }
    }

    /**
     * 判定两个树是否是包含关系
     */
    public boolean isSubtree(BtNode p, BtNode q) {
        if (p == null || q == null) {
            return false;
        }
        if (isTheSameTree(p, q)) {
            return true;
        } else {
            return isSubtree(p.left, q) || isSubtree(p.right, q);
        }
    }

    /**
     * 判断一棵二叉树是否是平衡二叉树
     * 时间复杂度：O(n2)
     */
    public boolean isBalanceTree(BtNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        } else {
            return isBalanceTree(root.left) && isBalanceTree(root.right);
        }
    }

    /**
     * 判断一棵二叉树是否是平衡二叉树(优化)
     * 时间复杂度：O(n)
     * 直接在求树的高度的函数上进行改进，当其不满足平衡二叉树时返回-1，满足的情况下再返回树的高度。
     */
    public boolean isBalanced(BtNode root) {
        return isBalancedPart(root) >= 0;
    }

    public int isBalancedPart(BtNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = isBalancedPart(root.left);
        int rightHeight = isBalancedPart(root.right);
        if (leftHeight >= 0 && rightHeight >= 0 && Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            return -1;
        }
    }

    /**
     * 判断一个二叉树是否对称
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(BtNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricChild(root.left, root.right);
    }

    public boolean isSymmetricChild(BtNode leftTree, BtNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        } else if (leftTree == null || rightTree == null) {
            return false;
        } else if (leftTree.val != rightTree.val) {
            return false;
        } else {
            return isSymmetricChild(leftTree.left, rightTree.right) && isSymmetricChild(leftTree.right, rightTree.left);
        }
    }

    /**
     * 二叉树的层序遍历，每层元素都要存储
     */
    public List<List<Integer>> levelOrder1(BtNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<BtNode> queue = new LinkedList<>();
        if(root == null){
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while(size != 0){
                BtNode cur = queue.poll();
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                list.add(cur.val);
                size--;
            }
            res.add(list);
        }
        return res;

    }
}
