package qrxedu.algorithm.day5.two;

import java.util.Stack;

/**
 * 给定一个栈的压入顺序以及该栈的可能的一个弹出顺序，判断该弹出顺序是否合理
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isPopOrder(int[] pushA, int[] popA){
        if(pushA == null || popA == null){
            return false;
        }
        if(pushA.length != popA.length){
            return false;
        }
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.empty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}
