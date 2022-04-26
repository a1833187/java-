package qrxedu.leedcode390;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    //TML
    public int lastRemaining1(int n) {
       List<Integer> list = new ArrayList<>();
       for(int i = 1; i <= n; i++){
           list.add(i);
       }
       while(list.size() != 1){
           int k1 = 0;
           while(k1 < list.size()){
               list.remove(k1++);
           }
           if(list.size() == 1){
               break;
           }
           int k2 = 0;
           while(list.size()-1-k2 >= 0){
               list.remove(list.size()-1-k2);
               k2++;
           }
       }
       return list.get(0);
    }
    public int lastRemaining(int n) {
        int k = 1,cnt = n;
        int step = 1;
        int a1 = 1;
        while(cnt > 1){
            if(k % 2 != 0){
                a1 = a1 + step;
            }else{
                a1 = cnt % 2 == 0 ? a1 : a1 + step;
            }
            k++;
            step <<= 1;
            cnt >>= 1;
        }
        return a1;
    }
}
