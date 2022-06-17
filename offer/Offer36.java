package qrxedu.offer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer36 {
    static class Node{
        int val;
        Node left;
        Node right;
    }
    Node prev = null;
    Node head;
    //将二叉搜索树转化为双向链表
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return root;
        }
        func(root);
        head.left = prev;
        prev.right = head;
        return head;

    }
    public void func(Node root){
        if(root == null){
            return;
        }
        func(root.left);
        if(prev != null){
            prev.right = root;
        }else{
            head = root;
        }
        root.left = prev;
        prev = root;
        func(root.right);
    }
}
