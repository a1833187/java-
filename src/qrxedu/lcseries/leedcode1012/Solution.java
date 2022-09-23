package qrxedu.lcseries.leedcode1012;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 至少有1位重复的数字: 等价于 n - 所有位都不同的数字.
 * 数位dp
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    //f是方便存储每一位对应的后续的合法值的格式,f是一个组合数
    static int[][] f = new int[10][10];
    //g存储低位的组合数
    static int[] g = new int[10];
    static{
        g[1] = 9;
        int cnt = 9;
        for(int i = 2; i < 10; i++){
            g[i] = g[i-1] + cnt * (10-i+1);
            cnt = cnt * (11-i);
        }
    }
    static{
        for(int l = 1; l < 10; l++){
            for(int r = l; r < 10; r++){
                f[l][r] = 1;
                for(int k = l; k <= r; k++){
                    f[l][r] *= k;
                }
            }
        }
    }
    public int numDupDigitsAtMostN(int n) {
        //list存储每一位的值.
        List<Integer> list = new ArrayList<>();
        int cur = n;
        while(cur != 0){
            list.add(cur % 10);
            cur/=10;
        }
        int k = list.size();
        int cr = 0;
        int ans = 0;
        //从高到低位遍历,第一位不能取0\
        //遍历位数相同的合法值.
        for(int i = k-1; i >= 0; i--){
            int num = list.get(i);
            int cnt = 0;
            if(i == k-1){
                cnt = num-1;
            }else{
                cnt = num;
            }
            //要保证和前面的位数的值不能重复.
            for(int j = i+1; j < k; j++){
                if(num > list.get(j)){
                    cnt--;
                }
            }
            //该位确定之后,后续位数排列组合的合法值个数.
            int a = 10-k+i;
            int b = 11-k;
            ans += a >= b ? cnt * f[b][a] : cnt;
            //用cr二级制的低位存储0-9是否遍历过.
            if((cr & (1<<num)) != 0){
                break;
            }
            //将当前的值记录起来.
            cr = cr ^ (1<<num);
            //如果n本身不含重复的值,那么需要加上n本身.
            if(i == 0){
                ans++;
            }
        }
        //加上的低位的合法值
        ans += g[k-1];
        //最终取反.
        return n - ans;
    }
    @Test
    public void show(){
        System.out.println(numDupDigitsAtMostN(200));
    }
}
