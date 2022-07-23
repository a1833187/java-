package qrxedu.e101;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class E45 {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> d = new LinkedList<>();
        int n = num.length;
        for(int i = 0; i < n; i++){
            while(!d.isEmpty() && num[d.peekLast()] <= num[i]){
                d.pollLast();
            }
            d.addLast(i);
            if(i >= size - 1){
                ans.add(num[d.peekFirst()]);
                if(i - size + 1 == d.peekFirst()){
                    d.pollFirst();
                }
            }
        }
        return ans;
    }
}
