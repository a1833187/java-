package qrxedu.lcseries.leedcode1305;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        getPath(l1,root1);
        getPath(l2,root2);
        List<Integer> ans = new ArrayList<>();
        int i1 = 0,i2 = 0;
        int n1 = l1.size(), n2 = l2.size();
        while(i1 < n1 && i2 < n2){
            if(l1.get(i1) <= l2.get(i2)){
                ans.add(l1.get(i1));
                i1++;
            }else{
                ans.add(l2.get(i2));
                i2++;
            }
        }
        if(i1 == n1){
            for(;i2 < n2; i2++){
                ans.add(l2.get(i2));
            }
        }else{
            for(;i1 < n1; i1++){
                ans.add(l1.get(i1));
            }
        }
        return ans;
    }
    public void getPath(List<Integer> l,TreeNode root){
        if(root == null){
            return;
        }
        getPath(l,root.left);
        l.add(root.val);
        getPath(l,root.right);
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
