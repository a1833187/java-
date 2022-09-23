package qrxedu.e101;

/**
 * 分糖果问题:首先所有人都至少分到1个糖果,当一个人比前一个人得分多时糖果个数为前一个人的糖果个数+1
 * 但如果一个人得分比前一个人得分少,那么不是-1,而是从1反向加到某个值.
 * @author qiu
 * @version 1.8.0
 */
public class E95 {
    public int candy (int[] arr) {
        // write code here
        int n = arr.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = 1;
        }
        for(int i =1; i < n; i++){
            if(arr[i] > arr[i-1]){
                ans[i] = ans[i-1]+1;
            }
        }
        int res = ans[n-1];
        //从右向左遍历,将不符合得分的糖果个数更新并统计其和
        for(int i = n-2; i>= 0; i--){
            if(ans[i] <= ans[i+1] && arr[i] > arr[i+1]){
                ans[i] = ans[i+1]+1;

            }
            res += ans[i];
        }
        return res;
    }
}
