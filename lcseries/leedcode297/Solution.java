package qrxedu.lcseries.leedcode297;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val){
            this.val = val;
        }
    }
    List<String> l = new ArrayList<>();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        String s = l.toString();
        return s.substring(1,s.length()-1);

    }
    private void dfs(TreeNode p){
        if(p == null){
            l.add("null");
            return;
        }
        l.add(p.val+"");
        dfs(p.left);
        dfs(p.right);

    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       String[] strs = data.split(", ");
       return dfs1(strs);
    }
    int index = 0;
    private TreeNode dfs1(String[] strs){
        if(index == strs.length){
            return null;
        }
        if("null".equals(strs[index])){
            return null;
        }
        TreeNode p = new TreeNode(Integer.parseInt(strs[index]));
        index++;
        p.left = dfs1(strs);
        index++;
        p.right = dfs1(strs);
        return p;
    }
    @Test
    public void show(){
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        r1.left = r2;
        r1.right = r3;
        r3.left = r4;
        r3.right = r5;
        String s = serialize(r1);
        deserialize(s);
    }
}
