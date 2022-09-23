package qrxedu.lcseries.leedcode1713;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 得到子序列的最少操作次数
 * 原问题可以转化为t的长度减去两个数组的最长子序列的长度是多少.
 * 因为t中的元素是不重复的,所以LCS问题(最长子序列)又可以转换为LIS问题(最长上升子序列)
 * 可以转换的原因是因为,t中每个元素唯一,所以可以将其等价为对应的下标.然后可以用一个新的数组
 * 来记录a中每个元素在t中对应的下标(如果在t中不存在则不记录)
 * 这样只需要考虑新的数组中的最长上升子序列即可(因为t中的下标是严格递增的.)
 * LIS的时间复杂度可以优化到O(nlogn).
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int minOperations(int[] t,int[] a){
        int m = t.length;
        int n = a.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            map.put(t[i],i);
            t[i] = i;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
           if(map.containsKey(a[i])){
               list.add(map.get(a[i]));
           }
        }
        n = list.size();
        if(n == 0){
            return m;
        }
        int[] g = new int[n];
        for(int i = 0; i < n; i++){
            g[i] = list.get(i);
        }
        int[] f = new int[n];
        f[0] = g[0];
        int len = 1;
        for(int i = 1; i < n; i++){
            if(g[i] > f[len-1]){
                f[len++] = g[i];
            }else{
                int l = 0, r = len-1;
                while(l < r){
                    int mid = (l+r)>>1;
                    //这得是等于,否则会对于相等的而言会多一个.
                    if(f[mid] >= g[i]){
                        r = mid;
                    }else{
                        l = mid+1;
                    }
                }
                f[l] = g[i];
            }
        }
        return m - len;
    }

    public int minOperations1(int[] target, int[] arr) {
        int m = target.length;
        int n = arr.length;
        int[][] f = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            f[i][0] = i;
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                int t = target[i-1];
                int a = arr[j-1];
                if(t == a){
                    f[i][j] = f[i-1][j-1]+1;
                }else{
                    f[i][j] = Math.max(f[i][j-1],f[i-1][j]);
                }
            }
        }

        return m-f[m][n];
    }
    @Test
    public void show(){
        int[] target = {995168292,13690313,293160801,642482000,810529261,98173438,456394738,882168981,961299834,794671198};
        int[] arr = {13690313,794671198,957156640,882168981,882168981,293160801,794671198,111281680,293160801,642482000};
        System.out.println(minOperations(target,arr));
    }
}
