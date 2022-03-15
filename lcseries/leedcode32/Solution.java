package qrxedu.leedcode32;

import java.util.Deque;
import java.util.LinkedList;

/**
 * dp[i]表示以i结尾的最长有效子串的长度
 * 当s[i]为'(',肯定为0
 * 当s[i]为')':
 * 1. 当s[i-1]为'(',dp[i] = 2 + dp[i-2]
 * 2. 当s[i-1]为')':
 *     如果s[i-2-dp[i-1]]为左括号,我们可以把这个看成1:dp[i] = dp[i-1]+2+dp[i-2-dp[i-2]],和1相比
 *     多了一个dp[i-1],即单独把中间一部分的最长子串长度取出来。
 *     如果s[i-2-dp[i-1]]为右括号,则dp[i] = 0,不用处理。如：)()  ) ) (())  )
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = 2 + (i>2?dp[i-2]:0);
                }else if(i-dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) == '('){
                    dp[i] = 2+ dp[i-1] + (i - dp[i-1] - 2 > 0 ?dp[i-dp[i-1]-2]:0);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    /**
     * 括号-->栈
     * 巧妙地是用-1来衔接最长子串的首位置的前一位，然后和后面的有效最长字串的首位的更新做到了同步
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s){
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max,i - stack.peek());
                }
            }
        }
        return max;
    }
}
