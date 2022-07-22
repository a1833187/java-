package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E38 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        if(root == null){
            return -1;
        }
        int l = lowestCommonAncestor(root.left,o1,o2);
        int r = lowestCommonAncestor(root.right,o1,o2);
        if(root.val == o1){
            return o1;
        }else if(root.val == o2){
            return o2;
        }
        if(l != -1 && r != -1){
            return root.val;
        }else if(l == -1){
            return r;
        }else{
            return l;
        }
    }
}
