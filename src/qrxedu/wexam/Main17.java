package qrxedu.wexam;

import org.junit.jupiter.api.Test;

/**
 * 满二叉树的 LCA(最近公共祖先)
 * @author qiu
 * @version 1.8.0
 */
class Node{
    int val;
    Node left;
    Node right;
}
public class Main17 {
    public int getLCA(int a, int b) {
        int len = Math.max(a,b);
        Node[] arr = new Node[len+1];
        for(int i = 1; i <= len; i++){
            arr[i] = new Node();
        }
        for(int i = 1; i <= len; i++){
            arr[i].val = i;
            if(2 * i <= len) {
                arr[i].left = arr[2 * i];
            }
            if(2 * i + 1 <= len) {
                arr[i].right = arr[2 * i + 1];
            }
        }
        Node r = getLcaChild(arr[a],arr[b],arr[1]);
        return r.val;
    }
    public Node getLcaChild(Node root1,Node root2,Node root){
        if(root == null){
            return null;
        }
        if(root.val == root1.val || root.val == root2.val){
            return root;
        }
        Node left = getLcaChild(root1,root2,root.left);
        Node right = getLcaChild(root1,root2,root.right);
        if(left != null && right != null){
            return root;
        }else if(left != null){
            return left;
        }else{
            return right;
        }
    }
    @Test
    public void show(){
        System.out.println(getLCA(2,3));
    }
}

