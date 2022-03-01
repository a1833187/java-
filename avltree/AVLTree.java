package com.qrxedu.avltree;

/**
 * AVL树和二叉搜索树只有在创建的时候不一样，其他的基本上一致。
 *
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class AVLTree {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node root = null;

    /**
     * @param root:根节点
     * @return 以root为根结点的树的高度
     */
    public int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }

    public boolean Insert(int key) {
        if (root == null) {
            root = new Node(key);
            return true;
        }
        Node cur = root;
        Node prev = null;
        while (cur != null) {
            if (cur.val < key) {
                prev = cur;
                cur = cur.right;
            } else if (cur.val > key) {
                prev = cur;
                cur = cur.left;
            } else {
                return false;
            }
        }
        if (prev.val < key) {
            prev.right = new Node(key);
        } else {
            prev.left = new Node(key);
        }
        if (heightOfTree(root.right) - heightOfTree(root.left) > 1) {
            //在左旋之前要对根节点的右树进行判断其右树的左树高度是否高于右树的右树的高度，
            // 如果大于则需要将其进行右旋处理否则左旋之后的树也是一颗非平衡树
            if (heightOfTree(root.right.left) > heightOfTree(root.right.right)) {
                rightRotate(root.right);
            }
            leftRotate(root);
            return true;
        }
        if (heightOfTree(root.left) - heightOfTree(root.right) > 1) {
            if (heightOfTree(root.left.right) > heightOfTree(root.left.left)) {
                leftRotate(root.left);
            }
            rightRotate(root);
        }
        return true;
    }

    /**
     * @param root：根节点 对该树进行左旋
     */
    public void leftRotate(Node root) {
        //定义一个新节点使其值等于根节点的值
        Node newRoot = new Node(root.val);
        //令新节点的左树指向根节点的左树
        newRoot.left = root.left;
        //令新节点的右树指向根节点的右节点的左树
        newRoot.right = root.right.left;
        //将根节点的值改为根节点的右节点的值
        root.val = root.right.val;
        //将根节点的右树指向根节点的右节点的右树
        root.right = root.right.right;
        //将根节点的左树指向新节点
        root.left = newRoot;
    }

    /**
     * @param root:根节点 对该树进行右旋(和左旋正好相反)
     */
    public void rightRotate(Node root) {
        Node newNode = new Node(root.val);
        newNode.right = root.right;
        newNode.left = root.left.right;
        root.val = root.left.val;
        root.left = root.left.left;
        root.right = newNode;
    }
}
