package qrxedu.lcseries.leedcode406;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 首先按身高从低到高进行排序.不考虑身高相同的情况,排好序后从低到高插入队列时第i个人前面的人不会影响第i个人(身高均小于第i个人)
 * 只有第i个人之后的人会影响到第i个人.因此在对第i个人插入是,需要在给第i个人之前流k[i]个空位,即第i个人应该插入到
 * 第k[i]+1个位置.
 * 然后我们考虑身高相同时的情况.假设两个人身高相同. 假设有3个人分别是[1,0],[7,1],[7,2],在第一个人插入后
 * 假设先插入[7,1],那么只剩下最后1个位置,而[7,2]按理说应该插入到第2个空位,所以发生了错误;
 * 那么如果先插入[7,2],再插入[7,1]就无影响
 * 因此当身高相同时,按照k的降序排列
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        int n = people.length;
        int[][] res = new int[n][];
        int idx = 0;
        for(int[] p : people){
            int space = p[1]+1;
            for(int i = 0; i < n; i++){
                if(res[i] == null){
                    space--;
                }
                if(space == 0){
                    res[i] = p;
                    break;
                }
            }
        }
        return res;
    }
    @Test
    public void show(){
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));
    }
}
