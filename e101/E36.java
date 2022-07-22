package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E36 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val){
            this.val = val;
        }
    }
    public int h;
    public boolean IsBalanced_Solution(TreeNode root) {
        getHeight(root);
        return h != -1;
    }
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getHeight(root.left) + 1;
        int right = getHeight(root.right) + 1;
        if(Math.abs(left - right) > 1){
            h = -1;
            return -1;
        }
        return Math.max(left,right);
    }
    @Test
    public void show(){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
       TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t2.left = t3;
        t3.left = t4;
        t4.left = t5;
        System.out.println(IsBalanced_Solution(t1));
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(1);
        l.add(1);
        System.out.println(l.toString().substring(1,l.toString().length()-1));

    }
}
