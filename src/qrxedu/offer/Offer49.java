package qrxedu.offer;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer49 {

    public int nthUglyNumber(int n) {
        int[] f = {2,3,5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> p = new PriorityQueue<>();
        set.add(1L);
        p.offer(1L);
        int ugly = 1;
        for(int i = 0; i < n; i++){
            long cur = p.poll();
            ugly = (int)cur;
            for(int num : f){
                if(!set.contains(cur*num)){
                    set.add(cur*num);
                    p.offer(cur*num);
                }
            }
        }
        return ugly;
    }
    public int nthUglyNumber1(int n) {
        //dp得到结果:后面的丑数一定是前面的某个丑数乘2,3或5得来的
        int[] f = new int[n+1];
        f[1] = 1;
        int p2 = 1,p3 = 1,p5 = 1;
        for(int i = 2; i <= n; i++){
            int num2 = f[p2] * 2;
            int num3 = f[p3] * 3;
            int num5 = f[p5] * 5;
            f[i] = Math.min(num2,Math.min(num3,num5));
            if(f[i] == num2){
                p2++;
            }
            if(f[i] == num3){
                p3++;
            }
            if(f[i] == num5){
                p5++;
            }
        }
        return f[n];
    }
    @Test
    public void show(){
        System.out.println(nthUglyNumber(10));
    }
}
