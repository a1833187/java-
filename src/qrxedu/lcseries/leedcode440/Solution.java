package qrxedu.lcseries.leedcode440;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    /**
     * 优先级队列 进行字典序排列求k小数字，时间复杂度为O(n)
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int n, int k) {
        if(k == 1){
            return n;
        }
        PriorityQueue<String> p = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i = 1;i<=n;i++){
            if(p.size()<k){
                p.offer(i+"");
            }else{
                String s = i + "";
                if(s.compareTo(p.peek()) < 0){
                    p.poll();
                    p.offer(s);
                }
            }
        }
        return Integer.parseInt(p.peek());
    }

    /**
     * 字典树求字典序(总结博客)
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber1(int n,int k){
        int cur = 1;
        k--;
        while(k > 0){
            int step = getStep(cur,n);
            if(k >= step){
                k-=step;
                cur++;
            }else{
                cur = cur*10;
                k--;
            }
        }
        return cur;
    }
    public int getStep(int cur,int n){
        int step = 0;
        int first = cur;
        int last = cur;
        while(first <= n){
            step+=Math.min(last,n) - first + 1;
            first = first * 10;
            last = last * 10 + 9;
        }
        return step;
    }

    @Test
    public void show(){
        System.out.println(findKthNumber(2,1));
    }

}
