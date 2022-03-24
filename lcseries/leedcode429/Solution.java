package qrxedu.leedcode429;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * N叉树的层序遍历
 * @author qiu
 * @version 1.8.0
 */
class Node{
    public int val;
    public List<Node> children;
    public Node(int val){
        this.val = val;
    }
}
public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size != 0){
                Node no = queue.poll();
                list.add(no.val);
                for(int i = 0; i < no.children.size(); i++){
                    Node n = no.children.get(i);
                    if(n != null){
                        queue.offer(n);
                    }
                }
                size--;
            }
            res.add(list);
        }
        return res;
    }
}
