package qrxedu.lcseries.leedcode739;

import java.util.Stack;

/**
 * 单调栈:找左侧/右侧第一个比当前位置大或小的元素时可以考虑使用单调栈
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];
        ans[n-1] = 0;
        s.push(n-1);
        for(int i = n-2; i >= 0; i--){
            while(!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]){
                s.pop();
            }
            if(!s.isEmpty()){
                ans[i] = s.peek() - i;
            }
            s.push(i);
        }
        return ans;
    }
}
