package com.qrxedu.binarytree;

import com.sun.deploy.security.DeployAuthenticator;

import javax.swing.tree.TreeNode;
import java.util.*;

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
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size != 0) {
                BtNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                list.add(cur.val);
                size--;
            }
            res.add(list);
        }
        return res;
    }

    /**
     * 二叉搜索树求公共祖先
     */
    public BtNode lowestCommonAncestor0(BtNode root, BtNode p, BtNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val < p.val && root.val > q.val || root.val > p.val && root.val < q.val) {
            return root;
        }
        return null;

    }

    /**
     * 求二叉树最近的公共祖先(LCA):前提是这棵二叉树的所有结点的值都不相同
     * 思路:类似于二叉搜索树求最近的公共祖先。两个子节点的公共祖先要不存在三种情况,要不root就是公共祖先
     * 要不公共祖先在root的左侧，要不公共祖先在root的右侧
     * 其中root是公共祖先的条件是root == p || root == q,如果不满足 就递归其左树和右树
     */
    public BtNode lowestCommonAncestor(BtNode root, BtNode p, BtNode q) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }
        BtNode leftT = lowestCommonAncestor(root.left, p, q);
        BtNode rightT = lowestCommonAncestor(root.right, p, q);
        if (leftT != null && rightT != null) {
            return root;
        } else if (leftT != null) {
            return leftT;
        } else {
            return rightT;
        }
    }

    /**
     * 将root 到 p的路径保存到栈中
     *
     * @param root
     * @param p
     * @param stack
     * @return
     */
    public boolean getPath(BtNode root, BtNode p, Stack<BtNode> stack) {
        if (root == null) {
            return false;
        }
        stack.push(root);
        if (root == p) {
            return true;
        }
        boolean flag = getPath(root.left, p, stack);
        if (flag) {
            return true;
        } else {
            flag = getPath(root.right, p, stack);
            if (flag) {
                return true;
            } else {
                stack.pop();
                return false;
            }
        }
    }

    /**
     * 求二叉树最近的公共祖先(LCA):前提是这棵二叉树的所有结点的值都不相同
     * 思路: 考虑孩子双亲表示法转化为为两个相交链表求交点
     * 难点是如何找到这两个路径：用两个栈来保存root 到p 和 q 的路径。
     */
    public BtNode lowestCommonAncestor1(BtNode root, BtNode p, BtNode q) {
        if (root == null) {
            return null;
        }
        Stack<BtNode> stack1 = new Stack<>();
        Stack<BtNode> stack2 = new Stack<>();
        getPath(root, p, stack1);
        getPath(root, q, stack2);
        int size1 = stack1.size();
        int size2 = stack2.size();
        if (size1 > size2) {
            int len = size1 - size2;
            while (len > 0) {
                stack1.pop();
                len--;
            }
        } else {
            int len = size2 - size1;
            while (len > 0) {
                stack2.pop();
                len--;
            }
        }
        while (!stack1.empty() && !stack2.empty()) {
            if (stack1.peek() == stack2.peek()) {
                return stack1.pop();
            } else {
                stack1.pop();
                stack2.pop();
            }
        }
        return null;
    }

    /**
     * 将二叉搜索树转化为双向链表
     * 中序遍历二叉搜索树即为一个有序序列
     */
    public BtNode prev;

    public void InOrder(BtNode root) {
        if (root == null) {
            return;
        }
        InOrder(root.left);
        root.left = prev;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        InOrder(root.right);
    }

    public BtNode convert(BtNode root) {
        if (root == null) {
            return null;
        }
        InOrder(root);
        while (prev.left != null) {
            prev = prev.left;
        }
        return prev;
    }

    /**
     * 用前序序列与中序序列创建二叉树
     * 首先根据前序序列找到根root在中序序列中的位置
     * 然后递归中序序列中根root的左子树和根root的右子树
     */
    public int preIndex = 0;

    public BtNode createTreeBPandI(int[] preorder, int[] inorder, int beginIndex, int endIndex) {
        if (beginIndex > endIndex) {
            return null;
        }
        BtNode root = new BtNode(preorder[preIndex]);
        int rootIndex = findRootIndex(inorder, beginIndex, endIndex, preorder[preIndex]);
        preIndex++;
        root.left = createTreeBPandI(preorder, inorder, beginIndex, rootIndex - 1);
        root.right = createTreeBPandI(preorder, inorder, rootIndex + 1, endIndex);
        return root;
    }

    public int findRootIndex(int[] inorder, int beginIndex, int endIndex, int key) {
        for (int i = beginIndex; i <= endIndex; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public BtNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return createTreeBPandI(preorder, inorder, 0, preorder.length - 1);
    }

    /**
     * 用后序序列与中序序列创建二叉树
     * 后序遍历序列从后往前先是根然后是右子树最后是左子树
     */

    public BtNode createTreeBPandI1(int[] postorder, int[] postIndex, int[] inorder, int beginIndex, int endIndex) {
        if (beginIndex > endIndex) {
            return null;
        }
        BtNode root = new BtNode(postorder[postIndex[0]]);
        int rootIndex = findRootIndex1(inorder, beginIndex, endIndex, postorder[postIndex[0]]);
        postIndex[0]--;
        root.right = createTreeBPandI1(postorder, postIndex, inorder, rootIndex + 1, endIndex);
        root.left = createTreeBPandI1(postorder, postIndex, inorder, beginIndex, rootIndex - 1);
        return root;
    }

    public int findRootIndex1(int[] inorder, int beginIndex, int endIndex, int key) {
        for (int i = beginIndex; i <= endIndex; i++) {
            if (inorder[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public BtNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        //因为后序遍历的根是在最后，所以无法提前设置全局变量使其的值为后序遍历序列的长度 - 1
        //但是要保证这个变量的值不随递归本身的变化而变化。
        int[] postIndex = new int[1];
        postIndex[0] = postorder.length - 1;
        return createTreeBPandI1(postorder, postIndex, inorder, 0, postorder.length - 1);
    }

    /**
     * 根据二叉树创建字符串(力扣上的题)
     */
    public void treeToString(BtNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left != null) {
            sb.append('(');
            treeToString(root.left, sb);
            sb.append(')');
        } else {
            if (root.right == null) {
                return;
            } else {
                sb.append("()");
            }
        }
        if (root.right == null) {
            return;
        } else {
            sb.append('(');
            treeToString(root.right, sb);
            sb.append(')');

        }
    }

    public String tree2str(BtNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        treeToString(root, sb);
        return sb.toString();
    }

    /**
     * 二叉树最大宽度
     * 对于这道题的给定条件，统计每层有效元素的个数是很难的，这道题需要记录的是每一层首尾有效元素的下标，然后相减、
     * 给每层元素从0开始编号。
     */
    /*public int count1 = 0;
    public int layer = 0;*/

    /*public int widthOfBinaryTree(BtNode root) {*/
       /* if(root == null){
            return 0;
        }
        Queue<BtNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            layer++;
            int size = queue.size();
            List<BtNode> list = new ArrayList<>();
            while(size!=0){
                BtNode cur = queue.poll();
                list.add(cur);
                if(cur!=null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
                size--;
            }
            int len = (int)(Math.pow(2,layer-1));
            for(int i = 0; i < list.size();i++){
                if(list.get(i) == null){
                    len--;
                }else{
                    break;
                }
            }
            for(int i = list.size()-1;i>=0;i--){
                if(list.get(i) == null){
                    len--;
                }else{
                    break;
                }
            }
            if(count1 < len){
                count1 =len;
            }
        }
        return count1;*/
    class ATreeNode {
        BtNode node;
        public int depth, pos;

        public ATreeNode(BtNode n, int dep, int pos1) {
            node = n;
            depth = dep;
            pos = pos1;
        }
    }

    public int widthOfBinaryTree(BtNode root) {
        if (root == null) {
            return 0;
        }
        Queue<ATreeNode> queue = new LinkedList<>();
        int res = 0;
        int left = 0,curDepth = 0,dep = 0,pos = 0;
        queue.offer(new ATreeNode(root,dep,pos));
        while(!queue.isEmpty()){
            ATreeNode a = queue.poll();
            if(a.node != null){
                queue.offer(new ATreeNode(a.node.left,a.depth+1,a.pos*2));
                queue.offer(new ATreeNode(a.node.right,a.depth+1,a.pos*2+1));
                //使left永远等于当前层的最左边一个非空结点
                if(curDepth != a.depth){
                    curDepth = a.depth;
                    left = a.pos;
                }
                res = Math.max(res,a.pos - left + 1);
            }

        }
        return res;
    }
}
