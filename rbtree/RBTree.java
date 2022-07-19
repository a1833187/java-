package qrxedu.rbtree;

import qrxedu.avltree.AVLTree;

/**
 * @author qiu
 * @version 1.8.0
 */
public class RBTree {
    static class RBTreeNode {
        public int val;
        public RBTreeNode left;
        public RBTreeNode right;
        public RBTreeNode parent;
        public COLOR color;

        public RBTreeNode(int val) {
            this.val = val;
            //默认插入的节点的颜色是红色,如果是黑色会造成插入的麻烦:
            //由于要满足任意一条路径上的黑色节点的个数相同,所以要在其他路径上新添加一些没有意义的黑色节点
            //而插入的节点是红色节点,我们只需要调节该路径上节点的颜色
            this.color = COLOR.RED;
        }
    }

    public RBTreeNode root;

    public boolean insert(int val) {
        if(root == null){
            root = new RBTreeNode(val);
            root.color = COLOR.BLACK;
            return true;
        }
        RBTreeNode node = new RBTreeNode(val);
        RBTreeNode cur = root;
        RBTreeNode p = null;
        while (cur != null) {
            if (cur.val < val) {
                p = cur;
                cur = cur.right;
            } else if (cur.val == val) {
                return false;
            } else {
                p = cur;
                cur = cur.left;
            }
        }
        if (p.val < val) {
            p.right = node;
        } else if (p.val > val) {
            p.left = node;
        }
        node.parent = p;
        cur = node;
        while (p != null && p.color == COLOR.RED) {
            RBTreeNode pp = p.parent;
            if (pp.left == p) {
                RBTreeNode uncle = pp.right;
                if (uncle != null && uncle.color == COLOR.RED) {
                    p.color = COLOR.BLACK;
                    uncle.color = COLOR.BLACK;
                    pp.color = COLOR.RED;
                    cur = pp;
                    p = cur.parent;
                } else {
                    if (cur == p.right) {
                        rotateLeft(p);
                        RBTreeNode tmp = cur;
                        cur = p;
                        p = tmp;
                    }
                    rotateRight(pp);
                    pp.color = COLOR.RED;
                    p.color = COLOR.BLACK;
                }
            } else {
                RBTreeNode uncle = pp.left;
                if (uncle != null && uncle.color == COLOR.RED) {
                    p.color = COLOR.BLACK;
                    uncle.color = COLOR.BLACK;
                    pp.color = COLOR.RED;
                    cur = pp;
                    p = cur.parent;
                } else {
                    if (cur == p.left) {
                        rotateRight(p);
                        RBTreeNode tmp = cur;
                        cur = p;
                        p = tmp;
                    }
                    rotateLeft(pp);
                    pp.color = COLOR.RED;
                    p.color = COLOR.BLACK;
                }
            }
        }
        //这个必须加,因为在插入的过程中,红黑树的根是在变化的,而变化则导致根节点的颜色得不到保证
        //尤其是遇见第一种青光将pp的颜色设置为红.
        root.color = COLOR.BLACK;
        return true;
    }

    private void rotateRight(RBTreeNode p) {
        RBTreeNode pp = p.parent;
        RBTreeNode newRoot = p.left;
        p.left = newRoot.right;
        if (p.left != null) {
            p.left.parent = p;
        }
        newRoot.right = p;
        p.parent = newRoot;
        if (pp != null) {
            if (pp.left == p) {
                pp.left = newRoot;
                newRoot.parent = pp;
            } else if (pp.right == p) {
                pp.right = newRoot;
                newRoot.parent = pp;
            }
        } else {
            newRoot.parent = null;
            root = newRoot;
        }
    }

    private void rotateLeft(RBTreeNode p) {
        RBTreeNode pp = p.parent;
        RBTreeNode subR = p.right;
        RBTreeNode subRL = subR.left;
        p.right = subRL;
        if (subRL != null) {
            subRL.parent = p;
        }
        subR.left = p;
        p.parent = subR;
        if (pp != null) {
            if (pp.left == p) {
                pp.left = subR;
                subR.parent = pp;
            } else if (pp.right == p) {
                pp.right = subR;
                subR.parent = pp;
            }
        } else {
            subR.parent = null;
            root = subR;
        }
    }

    public boolean isRBTree(){
        if(root == null){
            return true;
        }
        if(root.color == COLOR.RED){
            System.out.println("根节点的颜色必须是黑色的");
            return false;
        }
        if(!checkRedColor(root)){
            return false;
        }
        int blackNum = 0;
        RBTreeNode cur = root;
        while(cur != null){
            if(cur.color == COLOR.BLACK){
                blackNum++;
            }
            cur =  cur.left;
        }
        return checkBlackCnt(root,0,blackNum);

    }

    private boolean checkBlackCnt(RBTreeNode root,int curNum,int blackNum){
        if(root == null){
            return true;
        }
        if(root.color == COLOR.BLACK){
            curNum++;
        }
        if(root.left == null && root.right == null){
           if(curNum != blackNum){
                System.out.println("黑色数目的节点在不同路径上数目不一致");
                return false;
            }
        }
        return checkBlackCnt(root.left,curNum,blackNum) && checkBlackCnt(root.right,curNum,blackNum);

    }
    private boolean checkRedColor(RBTreeNode root){
        if(root == null){
            return true;
        }
        if(root.color == COLOR.RED){
            if(root.parent.color == COLOR.RED){
                System.out.println("出现了两个连续的红色节点");
                return false;
            }
        }
        return checkRedColor(root.left) && checkRedColor(root.right);
    }
    public void inOrder(RBTreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}
