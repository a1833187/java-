package qrxedu.lcseries.leedcode902;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大为N的数字组合
 * 数位dp
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        int m = digits.length;
        int cur = n;
        List<Integer> list = new ArrayList<>();
        while(cur != 0){
            list.add(cur%10);
            cur/=10;
        }
        int k = list.size();
        int[] g = new int[10];
        int sum = 0;
        int j = 0;
        for(int i = 1; i < 10; i++){
           while(j < m){
               int key = Integer.parseInt(digits[j]);
               if(i > key){
                   j++;
                   sum++;
               }else{
                   break;
               }
           }
           g[i] = sum;
        }
        int[] f = new int[k+1];
        for(int i = 1; i <= k; i++){
            f[i] = (int)Math.pow(m,k-i);
        }
        int ans = 0;
        boolean vv = true;
        for(int i = k - 1; i >= 0; i--){
            if(i != k-1 && !vv){
                break;
            }
            int num = list.get(i);
            ans += g[num]*f[k-i];
            vv = false;
            for(String str : digits){
                int key = Integer.parseInt(str);
                if(num == key){
                    vv = true;
                }
            }
        }
        int tmp;
        if(m != 1){
            tmp = m * ((int)Math.pow(m,k-1)-1)/(m-1);
        }else{
            tmp = (k-1);
        }
        ans += tmp;
        boolean flag = false;
        for(int l : list){
            flag = false;
            for(String str : digits){
                int key = Integer.parseInt(str);
                if(l == key){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        ans = flag ? ans + 1 : ans;
        return ans;
    }
    @Test
    public void show(){
        String[] d = {"5","6"};
        System.out.println(atMostNGivenDigitSet(d,19));
    }
}
