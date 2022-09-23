package qrxedu.lcseries.leedcode354;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 序列dp
 * 首先这道题不能像《最大会议数目II》一样寻找紧挨着i的前一个值.这是因为对于会议数目那道题而言,当你找到紧挨着的那个值last以后,就可以证明在
 * i会议的开始时间是一定早于last即last之前的.也就是说因为一个会议的开始时间一定小于结束时间,所以按照会议的结束时间进行排序就可以将会议的先后
 * 顺序排列好.所以影响会议开始前后的只有一个影响因素就是会议的结束时间,所以我们只需要根据会议的结束时间去考虑就行.
 * 但是这道题影响顺序的是两个因子:宽度和高度.而且两者之间没有一者可以决定另一者的顺序的规则.所以需要全面考虑两个因子.
 * 按照信封的宽度进行排序以后,对于f[i],我们需要知道前面的i-1个信封中最长序列的信封的最大高度.这样做并不好处理.
 * 所以f[i]的意义应该为以第i封信结尾的最长序列的长度,这样我们可以对前面i-1封信进行遍历得到高度满足的最大值.这种做法的时间复杂度为O(n2)
 * 我们可以对找i的前面高度合适的最大值这一过程进行优化.首先我们是按照宽度排好序的,所以我们只需要在此基础上去考虑高度.
 * 我们可以利用g数组来存储对应序列长度最长时的最小高度(最小才能保证后续的序列尽可能的长,比如{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}).
 * 刚开始最长长度为2是对应的最大高度为5(第二个信封的高度),但在遍历到{8,4}对应的以该信封结尾的最长序列的长度为2,此时我们更新最长序列的长度为2
 * 时的最小高度,这样可以保证后续的序列长度能够尽可能的长.
 * 当我们遍历到i时,我们知道以i信封结尾的最长序列的范围是[1,i+1].所以我们在这个范围内进行二分查找,查找的条件为第i个信封对应的高度和g[mid]对应的最小
 * 高度比较,进而得到符合高度条件的最长序列的值
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int n = envelopes.length;
        int[] f = new int[n];
        Arrays.fill(f,1);
        int[] g = new int[n];
        Arrays.fill(g,Integer.MAX_VALUE);
        g[0] = 0;
        int ans= 1;
        for(int i = 0, j = 0,len = 1; i < n; i++){
            if(envelopes[i][0] != envelopes[j][0]){
                while(j < i){
                    int prev = f[j],cur = envelopes[j][1];
                    if(g[prev] == len){
                        g[len++] = cur;
                    }else{
                        g[prev] = Math.min(g[prev],cur);
                    }
                    j++;
                }
            }
            int l = 0, r = len;
            while(l < r){
                int mid = (l+r)>>1;
                if(envelopes[i][1] <= g[mid]){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            f[i] = r;
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }
    @Test
    public void show(){
        int[][] arr = {{1,3},{3,5},{6,7},{6,8},{8,4},{9,5}};
        System.out.println(maxEnvelopes(arr));
    }
}
