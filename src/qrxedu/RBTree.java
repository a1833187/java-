package qrxedu;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class RBTree {
    static class RBTreeNode {
        int val;
        RBTreeNode left;
        RBTreeNode right;
        RBTreeNode parent;
        // color:1为黑色,0为红色
        int color;

        public RBTreeNode(int val) {
            this.val = val;
            this.color = 0;
        }
    }

    RBTreeNode root;

    public boolean insert(int val) {
        if (root == null) {
            root = new RBTreeNode(val);
            root.color = 1;
            return true;
        }
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
        RBTreeNode node = new RBTreeNode(val);
        if (p.left == cur) {
            p.left = node;
        } else {
            p.right = node;
        }

        RBTreeNode pp = p.parent;
        if (pp.left == p) {
            while (p != null && p.color == 0) {
                RBTreeNode uncle = null;
                if (pp != null) {
                    uncle = pp.right;
                }
                if (uncle != null && uncle.color == 0) {
                    p.color = 1;
                    uncle.color = 1;
                    pp.color = 0;
                    p = pp;
                } else {
                    if (p.right == node) {
                        rotateLeft(p);
                    }
                    rotateRight(pp);
                    pp.color = 0;
                    p.color = 1;
                }
            }
        } else {
            while (p != null && p.color == 0) {
                RBTreeNode uncle = null;
                if (pp != null) {
                    uncle = pp.left;
                }
                if (uncle != null && uncle.color == 0) {
                    p.color = 1;
                    uncle.color = 1;
                    pp.color = 0;
                    p = pp;
                } else {
                    if (p.left == node) {
                        rotateRight(p);
                    }
                    rotateLeft(pp);
                    pp.color = 0;
                    p.color = 1;
                }
            }
        }
        root.color = 1;
        return true;
    }

    public int remove(int val) {
        RBTreeNode replaced = getNode(val);
        RBTreeNode removed = replaced;

        if (removed.left != null && removed.right != null) {
            removed = getNextNode(removed);
        }
        RBTreeNode move = null;
        if (removed.left != null) {
            move = removed.left;
        } else {
            move = removed.right;
        }
        RBTreeNode p = removed.parent;
        if (move != null) {
            move.parent = p;
        }
        if (p.left == removed) {
            p.left = move;
        } else {
            p.right = move;
        }
        int oldVal = replaced.val;
        if (removed.val != replaced.val) {
            replaced.val = removed.val;
        }
        adjustStructre(p, removed.color, move);
        root.color = 1;
        return oldVal;
    }

    private void adjustStructre(RBTreeNode p, int color, RBTreeNode moved) {
        if (color == 0) {
            return;
        }
        do {
            if (p.left == moved) {
                RBTreeNode bro = p.right;
                RBTreeNode near = bro == null ? null : bro.left;
                RBTreeNode far = bro == null ? null : bro.right;
                if (judge(p) && judge(bro) && judge(near) && judge(far)) {
                    // 1.父亲节点和兄弟节点以及侄子节点均为黑色
                    bro.color = 0;
                    moved = p;
                    p = moved.parent;
                } else if ((p != null && p.color == 0) && judge(bro) && judge(near) && judge(far)) {
                    // 2.父亲节点节点为红色,兄弟节点和侄子节点为黑色
                    p.color = 1;
                    bro.color = 0;
                    return;
                } else if (bro != null && bro.color == 0) {
                    // 3.兄弟节点为红色
                    rotateLeft(p);
                    bro.color = 1;
                    p.color = 0;
                } else if (judge(bro) && (far != null && far.color == 0)) {
                    // 4.兄弟节点为黑色,远侄子节点为红色
                    rotateLeft(p);
                    p.color = 1;
                    bro.color = 0;
                    far.color = 1;
                    return;
                } else if (judge(bro) && judge(far) && (near != null && near.color == 0)) {
                    // 5.兄弟节点为黑色,远侄子节点为黑色,近侄子节点为红色
                    rotateRight(bro);
                    bro.color = 0;
                    near.color = 1;
                }
            } else {
                RBTreeNode bro = p.left;
                RBTreeNode near = bro == null ? null : bro.right;
                RBTreeNode far = bro == null ? null : bro.left;
                if (judge(p) && judge(bro) && judge(near) && judge(far)) {
                    // 1.父亲节点和兄弟节点以及侄子节点均为黑色
                    bro.color = 0;
                    moved = p;
                    p = moved.parent;
                } else if ((p != null && p.color == 0) && judge(bro) && judge(near) && judge(far)) {
                    // 2.父亲节点节点为红色,兄弟节点和侄子节点为黑色
                    p.color = 1;
                    bro.color = 0;
                    return;
                } else if (bro != null && bro.color == 0) {
                    // 3.兄弟节点为红色
                    rotateRight(p);
                    bro.color = 1;
                    p.color = 0;
                } else if (judge(bro) && (far != null && far.color == 0)) {
                    // 4.兄弟节点为黑色,远侄子节点为红色
                    rotateRight(p);
                    p.color = 1;
                    bro.color = 0;
                    far.color = 1;
                    return;
                } else if (judge(bro) && judge(far) && (near != null && near.color == 0)) {
                    // 5.兄弟节点为黑色,远侄子节点为黑色,近侄子节点为红色
                    rotateLeft(bro);
                    bro.color = 0;
                    near.color = 1;
                }
            }
        }while(p != null);
    }

    private boolean judge(RBTreeNode p) {
        return p == null || p.color == 1;
    }

    private RBTreeNode getNode(int val) {
        if (root == null) {
            return null;
        }
        RBTreeNode cur = root;
        while (cur != null && cur.val != val) {
            if (cur.val < val) {
                cur = cur.right;
            } else if (cur.val > val) {
                cur = cur.left;
            }
        }
        return cur;
    }

    private RBTreeNode getNextNode(RBTreeNode p) {
        RBTreeNode cur = p;
        if (cur.right != null) {
            cur = cur.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        } else {
            RBTreeNode parent = cur.parent;
            while (parent != null && parent.right == cur) {
                cur = parent;
                parent = cur.parent;
            }
            return parent;
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
        if (pp != null) {
            if (pp.left == p) {
                pp.left = subR;
            } else if (pp.right == p) {
                pp.right = subR;
            }
            subR.parent = pp;
        } else {
            subR.parent = null;
            root = subR;
        }
    }

    private void rotateRight(RBTreeNode p) {
        RBTreeNode pp = p.parent;
        RBTreeNode subL = p.left;
        RBTreeNode subLR = subL.right;

        p.left = subLR;
        if (subLR != null) {
            subLR.parent = p;
        }
        subL.right = p;
        if (pp != null) {
            if (pp.left == p) {
                pp.left = subL;
            } else if (pp.right == p) {
                pp.right = subL;
            }
            subL.parent = pp;
        } else {
            subL.parent = null;
            root = subL;
        }
    }
}
