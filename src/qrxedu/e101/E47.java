package qrxedu.e101;

import java.util.PriorityQueue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E47 {
    public int findKth(int[] a, int n, int k) {
        // write code here
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            if(i < k){
                p.offer(a[i]);
            }else{
                if(p.peek() < a[i]){
                    p.poll();
                    p.offer(a[i]);
                }
            }
        }
        return p.peek();
    }
}
