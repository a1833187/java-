package qrxedu.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ans = new int[k];
        int n = arr.length;
        if(n == 0){
            return ans;
        }
        PriorityQueue<Integer> p = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for(int num : arr){
            if(p.size() < k){
                p.offer(num);
            }else{
                if(p.peek() > num){
                    p.poll();
                    p.add(num);
                }
            }
        }
        for(int i = 0; i < k; i++){
            ans[i] = p.poll();
        }
        return ans;
    }
}
