package qrxedu.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Offer33 {
    /*
    利用单调栈
    对于根节点的右子树,其任意节点的值都大于根节点且小于根节点作为左子树的根节点的父亲节点
    对于根节点的左子树,其任意节点的值都小于根节点
    所以对于右节点序列而言,其是单调递增的.直接存入单调栈中(此时的root是根节点作为左子树的父亲节点),
    当需要遍历某个根节点的左节点时利用单调栈弹出该根节点的右子树以及该根节点的父亲节点
    所以一棵二叉搜索书的postorder[i]一定是小于root的

    总结:是右子树就直接假如到栈中,此时根节点不作更新
        是左子树就把根节点更新到当前节点的直系父亲节点
     */
    public boolean verifyPostorder1(int[] postorder) {
        //将根节点作为max的左子树
        int root = Integer.MAX_VALUE;
        Deque<Integer> q = new LinkedList<>();
        int n = postorder.length;
        for(int i = n - 1; i >= 0; i--){
            if(postorder[i] > root){
                return false;
            }
            while(!q.isEmpty() && q.peek() > postorder[i]){
                root = q.pop();
            }
            q.push(postorder[i]);
        }
        return true;
    }

    /*
    找出根节点的左子树和右子树,其中右子树中的值均大于根节点,然后递归判断左子树和右子树是否成立
     */
    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null){
            return true;
        }
       return getRes(postorder,0,postorder.length-1);
    }
    public boolean getRes(int[] post,int i,int j){
        if(i >= j){
            return true;
        }
        int p = i;
        while(post[p] < post[j]){
            p++;
        }
        int m = p;
        while(post[p] > post[j]){
            p++;
        }
        return p == j &&getRes(post,i,m-1) && getRes(post,m,j-1);
    }
}
