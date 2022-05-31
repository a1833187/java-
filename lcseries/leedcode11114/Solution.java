package qrxedu.leedcode11114;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 拓扑排序:检测一个有向图中是否有环
 * 具体步骤:首先统计所有入度为0的节点,并将这些节点放入队列中.每次从队列中取出1个,并记录到Sting中.并将与该点组成有向边的相邻节点的入度减1.如果这些节点中有入度被减为0的
 * 节点,则直接加入队列中.重复这个过程,直到队列为空.
 * 判断String中的节点个数是否等于最初的节点个数.
 * 如果有环,则inDegrees中至少有一个节点的入度个数变为了负数.
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    Map<Character,List<Character>> map = new HashMap<>();
    Map<Character,Integer> inDegrees = new HashMap<>();
    boolean valid = true;
    public String alienOrder(String[] words) {
       int n = words.length;
       for(String s : words){
           for(int i = 0; i <s.length(); i++){
               map.put(s.charAt(i),new ArrayList<>());
           }
       }
       for(int i = 1; i < n; i++){
           addEdge(words[i-1],words[i]);
       }
       if(!valid){
           return "";
       }
       Queue<Character> q = new LinkedList<>();
       Set<Character> set = map.keySet();
       for(char ch : set){
           if(!inDegrees.containsKey(ch)){
               q.offer(ch);
           }
       }
       StringBuilder s = new StringBuilder();
       while(!q.isEmpty()){
           char ch = q.poll();
           s.append(ch);
           List<Character> cur = map.get(ch);
           for(char c : cur){
               inDegrees.put(c,inDegrees.get(c)-1);
               if(inDegrees.get(c) == 0){
                   q.offer(c);
               }
           }
       }
       return s.length() == map.size() ? new String(s):"";
    }
    public void addEdge(String be,String af){
        int n1 = be.length();
        int n2 = af.length();
        int l = Math.min(n1,n2);
        int i = 0;
        for(; i < l; i++){
            char ch1 = be.charAt(i);
            char ch2 = af.charAt(i);
            if(ch1 != ch2){
                map.get(ch1).add(ch2);
                inDegrees.put(ch2,inDegrees.getOrDefault(ch2,0)+1);
                break;
            }

        }
        if(i == l && n1 > n2){
            valid = false;
        }
    }
    @Test
    public void show(){
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.println(alienOrder(words));
    }
}
