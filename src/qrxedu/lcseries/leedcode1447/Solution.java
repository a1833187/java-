package qrxedu.lcseries.leedcode1447;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        if(n == 1){
            return list;
        }
        for(int i = 2; i <= n; i++){
            for(int j = 1; j < i; j++){
                if(gcd(j,i) != 1){
                    continue;
                }
                list.add(j + "/" + i);
            }
        }
        return list;
    }
    public int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a%b);
    }
}
