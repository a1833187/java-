package qrxedu.offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        if(n == 0){
            return true;
        }
        Deque<Integer> s = new LinkedList<>();
        int i1 = 0,i2 = 0;
        while(i1 < n && i2 < n){
            if(s.size() != 0 && s.peek() == popped[i2]){
                s.pop();
                i2++;
                continue;
            }
            while(i1 < n && pushed[i1] != popped[i2]){
                s.push(pushed[i1]);
                i1++;
            }
            i1++;
            i2++;
        }
        if(i2 == n){
            return true;
        }else{
            for(;i2 < n; i2++){
                if(s.peek() != popped[i2]){
                    return false;
                }
                s.pop();
            }
        }
        return true;
    }
}
