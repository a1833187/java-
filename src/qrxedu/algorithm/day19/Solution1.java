package qrxedu.algorithm.day19;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution1 {
    static class Node{
        int val;
        Node left;
        Node right;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        Node[] arr1 = new Node[m+1];
        Node[] arr2 = new Node[n+1];
        for(int i = 1; i <= m; i++){
            arr1[i] = new Node();
        }
        for(int i = 1; i <= n; i++){
            arr2[i] = new Node();
        }
        createTree(arr1,m);
        createTree(arr2,n);
        merge(arr1[1],arr2[2]);
        bfs(arr1[1]);
    }
    public static void createTree(Node[] arr,int n){
        Scanner scanner = new Scanner(System.in);
        for(int i = 1; i <= n; i++){
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            int val = scanner.nextInt();
            if(left != 0) {
                arr[i].left = arr[left];
            }
            if(right != 0) {
                arr[i].right = arr[right];
            }
            arr[i].val = val;
        }
    }
    public static Node merge(Node root1,Node root2){
        if(root1 != null && root2 != null){
            root1.left = merge(root1.left,root2.left);
            root1.right = merge(root1.right,root2.right);
            root1.val = root1.val + root2.val;
            return root1;
        }else{
            return root1 == null ? root2 : root1;
        }
    }
    public static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (queue.size() > 1) {
            Node cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        if (queue.size() == 1) {
            System.out.print(queue.poll().val);
        }
    }
}
