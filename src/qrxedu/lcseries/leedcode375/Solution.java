package qrxedu.lcseries.leedcode375;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    //这里给f标记上static 并且初始化,能够保证所有测试样例中重复区间只计算一遍!!!
    static int[][] f = new int[210][210];
    public int getMoneyAmount(int n) {
        return dfs(1,n);
    }
    public int dfs(int l,int r){
        if(l >= r){
            return 0;
        }
        if(f[l][r] != 0){
            return f[l][r];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = l; i <= r; i++){
            ans = Math.min(ans,i + Math.max(dfs(l,i-1),dfs(i+1,r)));
            f[l][r] = ans;
        }
        return ans;
    }


    /*
    //二分不能解决这个问题.
        //主要原因为每次惩罚的金额不固定，最小惩罚次数不等同于猜中数字的最小成本。
        //1.首先选取1个数字,让这个数字左边的和 和 右边的和 的差值最小.
        //2.然后再从这个数字的两边分别选取一个这样的值,并留下较大的那个值
    public int getMoneyAmount1(int n) {

        return func(1,n);
    }
    //求[left,right]中的"中间值"
    public int getMid(int left,int right){
        int min = Integer.MAX_VALUE;
        int ans = left;
        for(int i = left+1; i < right; i++){
            int leftSum = (left + i -1)*(i-left)/2;
            int rightSum = (right+i+1)*(right - i)/2;
            if(min > Math.abs(leftSum-rightSum)){
                min = Math.abs(leftSum-rightSum);
                ans = i;
            }
        }
        return ans;
    }
    //进行"中间值"的相加
    public int func(int left,int right){
        if(left >= right){
            return 0;
        }
        int mid = getMid(left,right);
        return mid + Math.max(func(left,mid-1),func(mid+1,right));
    }*/
    @Test
    public void show(){
        System.out.println(getMoneyAmount(12));
    }
}
