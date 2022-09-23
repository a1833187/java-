package qrxedu.l612;

import java.util.Arrays;

/**
 * 尽可能均分糖果
 * 典型回溯,还有一种状压dp的方式,本质上也是回溯的思想
 * @author qiu
 * @version 1.8.0
 */
public class S3 {
    public int n;
    public int ans = Integer.MAX_VALUE;
    public int[] cookies;
    public int k;
    public int distributeCookies(int[] cookies,int k){
        Arrays.sort(cookies);
        this.cookies = cookies;
        this.k = k;
        n = cookies.length;
        backtrack(new int[k],n-1);
        return ans;
    }
    public void backtrack(int[] b,int start){
        if(start < 0){
            int tmp = Integer.MIN_VALUE;
            for(int num : b){
                tmp = Math.max(tmp,num);
            }
            ans = Math.min(ans,tmp);
            return;
        }
        int zeroCnt = 0;
        for(int num : b){
            if(num == 0){
                zeroCnt++;
            }
        }
        //要保证每个人至少分到一个包裹
        //如果剩余包裹不够每人分一个,直接return
        if(zeroCnt > start+1){
            return;
        }
        for(int i = 0; i < k; i++){
            //可以做一些适当的剪枝减少回溯次数


            b[i] += cookies[start];
            backtrack(b,start-1);
            b[i] -= cookies[start];
        }
    }
}
