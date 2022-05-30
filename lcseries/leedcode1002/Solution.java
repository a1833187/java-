package qrxedu.leedcode1002;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qiu
 * @version 1.8.0
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val){
        this.val = val;
    }
}
public class Solution {
    int ans = 0;
    Deque<Integer> q = new LinkedList<>();
    public int sumRootToLeaf(TreeNode root) {
        if(root == null){
            return 0;
        }
//        getSum(root);
//        return ans;
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int val){
        if(root == null){
            return 0;
        }
        //按照二进制的方式每次整体将val往右移一位并"加上"当前位.
        val = (val << 1) | (root.val);
        if(root.left == null && root.right == null){
            return val;
        }
        return dfs(root.left,val) + dfs(root.right,val);
    }
    public void getSum(TreeNode root){
        if(root == null){
            q.push(0);
            return;
        }
        if(root.left == null && root.right == null){
            q.push(root.val);
            Deque<Integer> cur = new LinkedList<>(q);
            int k = 0;
            int n = cur.size();
            for(int i = 0; i < n;i++){
                ans += cur.pop()<<(k++);
            }

            return;
        }
        q.push(root.val);
        getSum(root.left);
        q.pop();
        getSum(root.right);
        q.pop();
    }
    @Test
    public void show(){
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(0);
//        TreeNode r3 = new TreeNode(1);
//        TreeNode r4 = new TreeNode(0);
//        TreeNode r5 = new TreeNode(1);
//        TreeNode r6 = new TreeNode(0);
//        TreeNode r7 = new TreeNode(1);
        r1.right = r2;
//        r1.right = r3;
//        r2.left = r4;
//        r2.right = r5;
//        r3.left = r6;
//        r3.right = r7;
        System.out.println(sumRootToLeaf(r1));
    }
}
