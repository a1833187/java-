package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E39 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val){
            this.val = val;
        }
    }
    List<String> ans = new ArrayList<>();
    String Serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            while(size != 0){
                TreeNode cur = q.poll();
                if(cur != null){
                    ans.add(cur.val + "");

                    q.offer(cur.left);
                    q.offer(cur.right);
                }else{
                    ans.add("#");
                }
                size--;
            }
        }
        return ans.toString().substring(1,ans.toString().length()-1);
    }
    TreeNode Deserialize(String str) {
        String[] strs = str.split(", ");
        int n = strs.length;
        if(n == 1 && "".equals(strs[0])){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for(int i = 1; i < n-1; i+=2){
            TreeNode cur = q.poll();
            if(!"#".equals(strs[i])){
                cur.left = new TreeNode(Integer.parseInt(strs[i]));
                q.offer(cur.left);
            }
            if(!"#".equals(strs[i+1])){
                cur.right = new TreeNode(Integer.parseInt(strs[i+1]));
                q.offer(cur.right);
            }
        }
        return root;
    }
    @Test
    public void show(){
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(2);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t2.left = t3;
        t3.left = t4;
        //t3.right = t5;
        String s = Serialize(t1);
        Deserialize(s);
    }
}
