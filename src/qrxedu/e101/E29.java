package qrxedu.e101;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E29 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public boolean flag = false;
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if(root == null){
            return false;
        }
        dfs(root,sum);
        return flag;
    }
    public void dfs(TreeNode root,int sum){
        if(flag){
            return;
        }
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(sum == root.val){
                flag = true;
            }
            return;
        }
        dfs(root.left,sum-root.val);
        dfs(root.right,sum-root.val);


    }
}
