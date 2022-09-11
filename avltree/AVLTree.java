package qrxedu.avltree;

import java.beans.beancontext.BeanContext;
import java.util.Map;

/**
 * @author qiu
 * @version 1.8.0
 */
public class AVLTree {
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
        public int bf;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode root;
    public boolean insert(int val){
        if(root == null){
            root = new TreeNode(val);
            return true;
        }
        TreeNode p = null;
        TreeNode cur = root;
        while(cur != null){
            if(cur.val < val){
                p = cur;
                cur = cur.right;
            }else if(cur.val == val){
                //AVL树中不应该存在两个值相同的节点
                return false;
            }else{
                p = cur;
                cur = cur.left;
            }
        }
        TreeNode node = new TreeNode(val);
        if(p.val < val){
            p.right = node;
        }else if(p.val > val){
            p.left = node;
        }
        node.parent = p;
        cur = node;
        while(p != null){
            if(p.right == cur){
                p.bf++;
            }else if(p.left == cur){
                p.bf--;
            }
            if(p.bf == 0){
                break;
            }else if(p.bf == 1 || p.bf == -1){
                //继续向上寻找需要旋转的子树
                cur = p;
                p = p.parent;
            }else{
                //发生旋转
                if(p.bf == 2){
                    if(cur.bf == 1){
                        //左单旋
                        rotateLeft(p);
                    }else if(cur.bf == -1){
                        //右左双旋
                        rotateRL(p);
                    }
                }else if(p.bf == -2){
                    if(cur.bf == 1){
                        //左右双旋
                        rotateLR(p);
                    }else if(cur.bf == -1){
                        //右单旋
                        rotateRight(p);
                    }
                }
                break;
            }
        }
        return true;
    }
    public boolean remove(TreeNode p){
        // getNode(p)获得待删除节点
        TreeNode replaced = getNode(p);
        if(replaced == null){
            return false;
        }
        TreeNode removed = replaced;
        if(removed.left != null && removed.right != null){
            // 之所以说在找替罪羊结点时不会走到else语句块的原因就在于删除方法调用替罪羊方法的前提是待删除节点的左右子树均不为空.
            // 获取左树高度和右树高度
            int leftHeight = getHeight(removed.left);
            int rightHeight = getHeight(removed.right);
            // 这里需要判断一下左右树的高度来决定替罪羊是找前驱节点还是后继节点,因为删除意味着可能导致某一侧树的高度降低,所有替罪羊尽可能找在树高的一侧
            if(leftHeight > rightHeight){
                removed = getPrevNode(removed);
            }else{
                removed = getNextNode(removed);
            }
        }
        TreeNode moved = null;
        // 获取替罪羊节点的子树结构:至少有一侧为空
        if(removed.left != null){
            moved = removed.left;
        }else{
            moved = removed.right;
        }
        // 获取替罪羊节点的父亲节点
        TreeNode parent = removed.parent;

        // 将替罪羊父亲节点和替罪羊的子树节点连接起来
        if(moved != null){
            moved.parent = parent;
        }
        if(parent == null){
            root = moved;
            return true;
        }else if(parent.left == removed){
            parent.left = moved;
        }else{
            parent.right = moved;
        }
        // 将替罪羊节点的值赋给待删除节点,至此删除部分完成
        if(removed.val != replaced.val){
            replaced.val = removed.val;
        }
        // 调整删除后树的结构,以保证高度平衡
        adjustStructure(parent);
        return true;
    }
    private void adjustStructure(TreeNode p){
        do {
            // 获取左右树高度来判断具体怎么旋转
            int leftHeight = getHeight(p.left);
            int rightHeight = getHeight(p.right);
            // if语句中的逻辑和AVL树插入代码中的旋转逻辑一致
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
                // 注意树的结构如果发生改变,原来的父亲和儿子节点的关系发生对调,所以原来的父亲节点现在的关系其实是儿子,所以p.parent.parent才是爷爷节点
                p = p.parent.parent;
                continue;
            }
            // 如果树的结构没有发生改变那么p的关系还是父亲,p.parent就是父亲
            p = p.parent;
        }while(p != null);
    }
    private  int getHeight(TreeNode p){
        if(p == null){
            return 0;
        }
        return Math.max(getHeight(p.left),getHeight(p.right)) + 1;
    }
    private TreeNode getPrevNode(TreeNode p){
        if(p == null){
            return p;
        }
        TreeNode cur = p;
        if(cur.left != null){
            cur = cur.left;
            while(cur.right != null){
                cur = cur.right;
            }
            return cur;
        }else{
            TreeNode parent = cur.parent;
            while(parent != null && parent.left == cur){
                cur = parent;
                parent = cur.parent;
            }
            return parent;
        }
    }
    private TreeNode getNextNode(TreeNode p){
        if(p == null){
            return null;
        }
        TreeNode cur = p;
        if(cur.right != null){
            cur = cur.right;
            while(cur.left != null){
                cur = cur.left;
            }
            return cur;
        }else{
            TreeNode parent = cur.parent;
            while(parent != null && parent.right == cur){
                cur = parent;
                parent = cur.parent;
            }
            return parent;
        }
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
            }else{
                return cur;
            }
        }
        return null;
    }
    private void rotateLeft(TreeNode p){
        TreeNode pp = p.parent;
        TreeNode subR = p.right;
        TreeNode subRL = subR.left;
        p.right = subRL;
        if(subRL != null){
            subRL.parent = p;
        }
        subR.left = p;
        p.parent = subR;
        if(pp != null){
            if(pp.left == p){
                pp.left = subR;
                subR.parent = pp;
            }else if(pp.right == p){
                pp.right = subR;
                subR.parent = pp;
            }
        }else{
            subR.parent = null;
            root = subR;
        }
        subR.bf = 0;
        p.bf = 0;
    }
    private void rotateRight(TreeNode p){
        TreeNode pp = p.parent;
        TreeNode newRoot = p.left;
        p.left = newRoot.right;
        if(p.left != null){
            p.left.parent = p;
        }
        newRoot.right = p;
        p.parent = newRoot;
        if(pp != null){
            if(pp.left == p){
                pp.left = newRoot;
                newRoot.parent = pp;
            }else if(pp.right == p){
                pp.right = newRoot;
                newRoot.parent = pp;
            }
        }else{
            newRoot.parent = null;
            root = newRoot;
        }
        newRoot.bf = 0;
        p.bf = 0;
    }
    private void rotateLR(TreeNode p){
        TreeNode subL = p.left;
        TreeNode subLR = subL.right;
        int bf = subLR.bf;

        rotateLeft(p.left);
        rotateRight(p);
        //bf为0时旋转后的平衡因子均为0
        if(bf == -1){
            subL.bf = 0;
            subLR.bf = 0;
            p.bf = 1;
        }else if(bf == 1){
            subL.bf = -1;
            subLR.bf = 0;
            p.bf = 0;
        }
    }
    private void rotateRL(TreeNode p){
        TreeNode subR = p.right;
        TreeNode subRL = subR.left;
        int bf = subRL.bf;

        rotateRight(p.right);
        rotateLeft(p);
        if(bf == 1){
            subRL.bf = 0;
            subR.bf = 0;
            p.bf = -1;
        }else if(bf == -1){
            subRL.bf = 0;
            subR.bf = 1;
            p.bf = 0;
        }
    }
    public boolean flag = true;
    public int isBalanced(TreeNode root){
        //检测对AVL树中节点的操作的方法写的是否正确
        if(root == null){
            return 0;
        }
        if(!flag){
            return -1;
        }
        int leftH = isBalanced(root.left);
        int rightH = isBalanced(root.right);
        //检测自己写的计算平衡因子的方法是否正确.
        if(rightH - leftH != root.bf){
            System.out.println("节点值为" + root.val + "的平衡因子异常");
        }
        if(Math.abs(leftH-rightH) > 1){
            flag = false;
            return -1;
        }
        return Math.max(leftH,rightH)+1;

    }
}
