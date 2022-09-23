package qrxedu;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class AVLTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        int bf;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode root;

    public boolean insert(int val) {
        TreeNode p = new TreeNode(val);
        if (root == null) {
            root = p;
            return true;
        }
        TreeNode cur = root;
        while (cur.left != null && cur.right != null) {
            if (cur.val == p.val) {
                return false;
            }
            if (cur.val < p.val) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        if (cur.val < p.val) {
            cur.right = p;
        } else {
            cur.left = p;
        }
        p.parent = cur;
        while (cur != null) {
            if (cur.left == p) {
                cur.bf--;
            } else if (cur.right == p) {
                cur.bf++;
            }
            if (cur.bf >= 2) {
                if (p.bf >= 1) {
                    rotateLeft(cur);
                } else {
                    rotateRL(cur);
                }
            } else {
                if (p.bf >= 1) {
                    rotateLR(cur);
                } else {
                    rotateRight(cur);
                }
            }
            p = cur;
            cur = p.parent;
        }
        return true;
    }
    public int remove(int val){
        TreeNode p = new TreeNode(val);
        TreeNode replaced = getNode(p);
        if(replaced == null){
            throw new RuntimeException("AVL树中没有要删除的节点");
        }
        TreeNode removed = replaced;
        if(removed.left != null && removed.right != null){
            if(removed.bf < 0){
                removed = getPrevNode(removed);
            }else{
                removed = getNextNode(removed);
            }
        }
        TreeNode moved;
        TreeNode parent = removed.parent;
        if(removed.left != null){
            moved = removed.left;
        }else{
            moved = removed.right;
        }
        if(moved != null){
            moved.parent = parent;
        }
        if(parent.left == removed){
            parent.left = moved;
        }else{
            parent.right = moved;
        }
        int oldVal = replaced.val;
        if(replaced.val != removed.val){
            replaced.val = removed.val;
        }
        adujustStructre(parent);
        return oldVal;
    }
    private void adujustStructre(TreeNode p){
        do {
            int leftHeight = getHeight(p.left);
            int rightHeight = getHeight(p.right);
            if(Math.abs(leftHeight - rightHeight) >= 2){
                if(leftHeight > rightHeight){
                    TreeNode left = p.left;
                    if(getHeight(left.left) > getHeight(left.right)){
                        rotateRight(p);
                    }else{
                        rotateLR(p);
                    }
                }else{
                    TreeNode right = p.right;
                    if(getHeight(right.right) > getHeight(right.left)){
                        rotateLeft(p);
                    }else{
                        rotateRL(p);
                    }
                }
                p = p.parent.parent;
                continue;
            }
            p.bf = getHeight(p.right) - getHeight(p.left);
            p = p.parent;
        }while(p != null);
    }
    private TreeNode getNode(TreeNode p){
        if(p == null || root == null){
            return null;
        }
        TreeNode cur = root;
        while(cur != null && cur.val != p.val){
            if(cur.val < p.val){
                cur = cur.right;
            }else if(cur.val > p.val){
                cur = cur.left;
            }
        }
        return cur;
    }
    private void rotateRL(TreeNode p) {
        TreeNode pp = p.parent;
        TreeNode child = p.right;
        TreeNode s = child.left;
        rotateRight(child);
        rotateLeft(p);
        p.bf = getHeight(p.right) - getHeight(p.left);
        child.bf = getHeight(child.right) - getHeight(child.left);
        s.bf = getHeight(s.right) - getHeight(s.left);
    }

    private void rotateLR(TreeNode p) {
        TreeNode pp = p.parent;
        TreeNode child = p.left;
        TreeNode s = child.right;
        rotateLeft(p.left);
        rotateRight(p);
        p.bf = getHeight(p.right) - getHeight(p.left);
        child.bf = getHeight(child.right) - getHeight(child.left);
        s.bf = getHeight(s.right) - getHeight(s.left);
    }

    private void rotateRight(TreeNode p) {
        TreeNode pp = p.parent;
        TreeNode child = p.left;
        TreeNode s = child.right;
        p.left = s;
        if (s != null) {
            s.parent = p;
        }
        p.parent = child;
        child.right = p;
        if (pp != null) {
            if (pp.left == p) {
                pp.left = child;
                child.parent = pp;
            } else {
                pp.right = child;
                child.parent = pp;
            }
        } else {
            child.parent = null;
            root = child;
        }
        p.bf = getHeight(p.right) - getHeight(p.left);
        child.bf = getHeight(child.right) - getHeight(child.left);
    }

    private void rotateLeft(TreeNode p) {
        TreeNode pp = p.parent;
        TreeNode child = p.right;
        TreeNode s = child.left;
        p.right = s;
        if (s != null) {
            s.parent = p;
        }
        child.left = p;
        p.parent = child;
        if (pp != null) {
            if (pp.left == p) {
                pp.left = child;
                child.parent = pp;
            } else {
                pp.right = child;
                child.parent = pp;
            }
        } else {
            child.parent = null;
            root = child;
        }
        p.bf = getHeight(p.right) - getHeight(p.left);
        child.bf = getHeight(p.right) - getHeight(p.left);

    }

    private int getHeight(TreeNode p) {
        if (p == null) {
            return 0;
        }
        return Math.max(getHeight(p.left), getHeight(p.right)) + 1;
    }

    private TreeNode getNextNode(TreeNode p) {
        if (p == null || root == null) {
            return null;
        }
        TreeNode cur = p;
        if (cur.right != null) {
            cur = cur.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        } else {
            TreeNode parent = p.parent;
            while (parent != null && parent.right == cur) {
                cur = parent;
                parent = cur.parent;
            }
            return parent;
        }
    }

    private TreeNode getPrevNode(TreeNode p) {
        if (p == null || root == null) {
            return null;
        }
        TreeNode cur = p;
        if (cur.left != null) {
            cur = cur.left;
            while (cur.right != null) {
                cur = cur.right;
            }
            return cur;
        } else {
            TreeNode parent = cur.parent;
            while (parent != null && parent.left == cur) {
                cur = parent;
                parent = cur.parent;
            }
            return parent;
        }
    }
}
