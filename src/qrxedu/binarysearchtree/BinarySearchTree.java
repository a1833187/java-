package qrxedu.binarysearchtree;

/**
 * @author qiu
 * @version 1.8.0
 */
public class BinarySearchTree {
    class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val =  val;
        }
    }
    public Node root = null;
    public Node search(int key) {
        if (root == null) {
            return null;
        }
        return searchChild(root,key);
    }
    private Node searchChild(Node root,int val){
        if(root.val == val){
            return root;
        }
        if(root.val < val){
            return searchChild(root.right,val);
        }else{
            return searchChild(root.left,val);
        }
    }
    public Node searchNor(int key){
        if(root == null){
            return null;
        }
        Node cur = root;
        while(cur != null){
            if(cur.val == key){
                return cur;
            }else if(cur.val < key){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        return null;
    }
    public boolean Insert(int key){
        if(root == null){
            root = new Node(key);
            return true;
        }
        Node cur = root;
        Node prev = null;
        while(cur != null){
            if(cur.val < key){
                prev = cur;
                cur = cur.right;
            }else if(cur.val > key){
                prev = cur;
                cur = cur.left;
            }else{
                return false;
            }
        }
        if(prev.val < key){
            prev.right = new Node(key);
        }else{
            prev.left = new Node(key);
        }
        return true;
    }
    public void remove(int key){
        if(root == null){
            return;
        }
        Node cur = root;
        Node pre = null;
        while(cur != null){
            if(cur.val == key){
                break;
            }else if(cur.val < key){
                pre = cur;
                cur = cur.right;
            }else{
                pre = cur;
                cur = cur.left;
            }
        }
        if(cur.left == null){
            if(cur == root){
                root = root.right;
            }else if(cur == pre.left){
                pre.left = cur.right;
            }else{
                pre.right = cur.right;
            }
        }else if(cur.right == null){
            if(cur == root){
                root = root.left;
            }else if(cur == pre.left){
                pre.left = cur.left;
            }else{
                pre.right = cur.left;
            }
        }else{
            Node cur1 = cur.right;
            Node pre1 = cur;
            while(cur1.left != null){
                pre1 = cur1;
                cur1 = cur1.left;
            }
            cur.val = cur1.val;
            if(cur1 == pre1.left){
                pre1.left = cur1.right;
            }else{
                //只有一种情况，当被删除节点下的子树为一支右单支树时
                pre1.right = cur1.right;
            }
        }
    }
}
