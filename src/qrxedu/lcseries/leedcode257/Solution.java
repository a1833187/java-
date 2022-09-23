package qrxedu.lcseries.leedcode257;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        String str = "";
       /* binaryTreePaths(root,list,str);*/
        return list;
    }
   /* public void binaryTreePaths(TreeNode root,List<String> list,String str){
        if(root == null){
            return;
        }
        str += root.val + "" + "->";
        if(root.left == null && root.right == null){
            StringBuilder s = new StringBuilder();
            for(int i = 0; i < str.length()-2;i++){
                s.append(str.charAt(i));
            }
            list.add(s.toString());
        }
        binaryTreePaths(root.left,list,str);
        binaryTreePaths(root.right,list,str);
        int k = 0;
        for(int i = str.length()-1;i>0;i--){
            if(str.charAt(i) >='0' && str.charAt(i) <='9'&& str.charAt(i-1) == '>'){
                k = i;
                break;
            }
        }
        str = str.substring(0,k);
    }*/
}
