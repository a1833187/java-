package qrxedu.lcseries.leedcode0406;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        order(root,list);
        int n = list.size();

        for(int i = 0; i < n; i++){
            if(list.get(i).equals(p)){
                if(i + 1 < n){
                    return list.get(i+1);
                }
            }
        }
        return null;
    }
    public void order(TreeNode root,List<TreeNode> list){
        if(root == null){
            return;
        }
        order(root.left,list);
        list.add(root);
        order(root.right,list);

    }
}
