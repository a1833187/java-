package qrxedu.e101;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E46 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(k == 0){
            return ans;
        }
        int n = input.length;
        if(n == 0){
            return ans;
        }
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            if(i < k){
                p.offer(input[i]);
            }else{
                if(p.peek() > input[i]){
                    p.poll();
                    p.offer(input[i]);
                }
            }
        }
        while(!p.isEmpty()){
            ans.add(0,p.poll());
        }
        return ans;
    }
}
