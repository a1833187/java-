package qrxedu.algorithm.day7.two;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<Integer> topK(List<Integer> list,int k){
        PriorityQueue<Integer> p = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        List<Integer> res = new ArrayList<>();
        if(list == null || k <= 0){
            return res;
        }
        if(list.size() <= k){
            return list;
        }
        for(int i = 0; i < list.size(); i++){
            if(p.size() <= k){
                p.offer(list.get(i));
            }else{
                if(p.peek() > list.get(i)){
                    p.poll();
                    p.offer(list.get(i));
                }
            }
        }
        for(int i = 0; i < k; i++){
            res.add(p.poll());
        }
        return res;
    }
}
