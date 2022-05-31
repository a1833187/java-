package qrxedu.offer;

import java.beans.beancontext.BeanContext;

/**
 * 根据前序和中序创建二叉树
 * @author qiu
 * @version 1.8.0
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int v){
        val = v;
    }
}
public class Offer7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        return func(inorder,preorder,0,inorder.length-1,0);
    }
    public TreeNode func(int[] inorder,int[] preorder,int pre,int next,int index){
        if(pre > next){
            return null;
        }
        if(pre == next){
            return new TreeNode(inorder[pre]);
        }
        int key = preorder[index];
        //这个寻找每个节点对应的中间结点的index可以提前存储到一个hashmap中
        int mid = getIndex(inorder,key);
        TreeNode root = new TreeNode(key);
        root.left = func(inorder,preorder,pre,mid-1,index+1);
        //root.right的节点是在preorder中的mid-pre+1后的节点上
        root.right = func(inorder,preorder,mid+1,next,index+mid-pre+1);
        return root;
    }
    public int getIndex(int[] inorder,int key){
        int n = inorder.length;
        int i = 0;
        for(; i < n; i++){
            if(inorder[i] == key){
                break;
            }
        }
        return i;
    }
}
