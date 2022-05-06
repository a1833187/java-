package qrxedu.leedcode145;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        hb(root,list);
        return list;
    }
    public void hb(TreeNode root,List<Integer> list){
        if(root.left != null){
            hb(root.left,list);
        }
        if(root.right != null){
            hb(root.right,list);
        }
        list.add(root.val);
    }
}
