package qrxedu.leedcode427;

/**
 * 根据数组创建四叉树.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        Node root = new Node();
        if(n == 1){
            root.val = grid[0][0] == 1;
            root.isLeaf = true;
            return root;
        }
        dfs(root,grid,0,0,n);
        return root;
    }
    public void dfs(Node root,int[][] grid,int m,int n,int k){
        if(k == 1){
           root.val = grid[m][n] == 1;
           root.isLeaf = true;
           return;
        }
        boolean[] flag = isOne(grid,m,n,k);
        if(flag[0]){
            root.val = false;
            root.isLeaf = true;
            return;
        }
        if(flag[1]){
            root.val = true;
            root.isLeaf = true;
            return;
        }
        Node l1 = new Node();
        Node l2 = new Node();
        Node l3 = new Node();
        Node l4 = new Node();
        root.topLeft = l1;
        root.topRight = l2;
        root.bottomLeft = l3;
        root.bottomRight = l4;
        dfs(l1,grid,m,n,k/2);
        dfs(l2,grid,m,n+k/2,k/2);
        dfs(l3,grid,m+k/2,n,k/2);
        dfs(l4,grid,m+k/2,n+k/2,k/2);
    }
    public boolean[] isOne(int[][] grid,int m,int n,int k){
        boolean[] flag = new boolean[2];
        flag[0] = true;
        flag[1] = true;
        for(int i = m; i < m+k;i++){
            for(int j = n; j < n+k; j++){
                if(grid[i][j] == 0){
                    flag[1] = false;
                }else{
                    flag[0] = false;
                }
            }
        }
        return flag;
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
//if (n == 2) {
//        boolean flag = true;
//        boolean flag1 = true;
//        for (int i = 0; i < n; i++) {
//        for (int j = 0; j < n; j++) {
//        if (grid[i][j] != 0) {
//        flag = false;
//        }else{
//        flag1 = false;
//        }
//        }
//        }
//        if (flag) {
//        root.val = true;
//        root.isLeaf = true;
//        } else {
//        root.isLeaf = false;
//        root.val = true;
//        Node l1 = new Node(grid[0][0] == 0 ? false : true, true);
//        Node l2 = new Node(grid[0][1] == 0 ? false : true, true);
//        Node l3 = new Node(grid[1][0] == 0 ? false : true, true);
//        Node l4 = new Node(grid[1][1] == 0 ? false : true, true);
//        root.topLeft = l1;
//        root.topRight = l2;
//        root.bottomLeft = l3;
//        root.bottomRight = l4;
//        }
//        return root;
//        }