package qrxedu.avltree;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {30,20,90,60,180,40};
        AVLTree avlTree = new AVLTree();
        for(int i = 0; i < arr.length; i++){
            avlTree.insert(arr[i]);
        }
        avlTree.isBalanced(avlTree.root);
        System.out.println(avlTree.flag);
    }
}
