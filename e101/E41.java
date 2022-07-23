package qrxedu.e101;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E41 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val){
            this.val = val;
        }
    }
    public int n;
    public List<Integer> list = new ArrayList<>();
    public int[] solve (int[] xianxu, int[] zhongxu) {
        // write code here
        n = xianxu.length;
        if(n == 0){
            return new int[0];
        }

        TreeNode root = dfs(xianxu,zhongxu,0,n-1,0);
//        list.add(xianxu[0]);
//        int len = list.size();
//        int[] ans = new int[len];
//        for(int i = len-1; i >= 0; i--){
//            ans[len-1-i] = list.get(i);
//        }
//        return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<List<Integer>> l = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> curL = new ArrayList<>();
            while(size != 0){
                TreeNode cur = q.poll();
                curL.add(cur.val);
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
                size--;
            }
            l.add(curL);
        }
        int len = l.size();
        int[] ans = new int[len];
        int idx = 0;
        for(List<Integer> ll : l){
            ans[idx++] = ll.get(ll.size()-1);
        }
        return ans;
    }
    public TreeNode dfs(int[] pre,int[] vin,int l,int r,int cnt){
        if(cnt == n){
            return null;
        }
        int idx = getIdx(vin,pre[cnt],l,r);
        if(idx == -1){
            return null;
        }
        TreeNode root = new TreeNode(pre[cnt]);
        root.left = dfs(pre,vin,l,idx-1,cnt+1);
        root.right = dfs(pre,vin,idx+1,r,cnt+1+idx-l);
//        if(root.right != null){
//            list.add(root.right.val);
//        }
        return root;
    }
    private int getIdx(int[] vin,int key,int l,int r){
        for(int i = l;i <= r; i++){
            if(vin[i] == key){
                return i;
            }
        }
        return -1;
    }
    @Test
    public void show(){
        int[] pre = {1,2,4,5,3};
        int[] vin = {4,2,5,1,3};
        System.out.println(Arrays.toString(solve(pre, vin)));
    }
}
