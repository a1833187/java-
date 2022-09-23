package qrxedu.lcseries.leedcode762;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    static Set<Integer> list = new HashSet<>();
    static{
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(11);
        list.add(13);
        list.add(17);
        list.add(19);
        list.add(23);
        list.add(29);
    }
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int i = left; i <= right; i++){
            int cnt = 0;
            for(int j = 0; j <= 31; j++){
                if(((i>>j)&1)==1){
                    cnt++;
                }
            }
            if(list.contains(cnt)){
                ans++;
            }
        }
        return ans;
    }
}
