package qrxedu.rbtree;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Test {
    public static void main(String[] args) {
        RBTree rbTree = new RBTree();
        int[] arr = {4,2,6,1,3,5,15,7,16,14};
        for(int i = 0; i < arr.length; i++){
            rbTree.insert(arr[i]);
        }
        System.out.println(rbTree.isRBTree());
        rbTree.inOrder(rbTree.root);
    }
}
