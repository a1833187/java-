package qrxedu.e101;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E40 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val){
            this.val = val;
        }
    }
    int n;
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        n = pre.length;
        if(n == 0){
            return null;
        }
        return dfs(pre,vin,0,n-1,0);
    }
    public TreeNode dfs(int[] pre,int[] vin,int l,int r,int cnt){
        if(cnt == n){
            return null;
        }
        int idx = getIdx(pre[cnt],vin,l,r);
        if(idx == -1){
            return null;
        }
        TreeNode root = new TreeNode(pre[cnt]);
        root.left = dfs(pre,vin,0,idx-1,cnt+1);
        root.right = dfs(pre,vin,idx+1,n-1,cnt+1+idx-l);
        return root;
    }
    public int getIdx(int key,int[] vin,int l,int r){
        int n = vin.length;
        for(int i = l; i <= r; i++){
            if(vin[i] == key){
                return i;
            }
        }
        return -1;
    }
    @Test
    public void show(){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] vin = {4,7,2,1,5,3,8,6};
        System.out.println(reConstructBinaryTree(pre,vin));
    }
}
