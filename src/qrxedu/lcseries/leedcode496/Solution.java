package qrxedu.lcseries.leedcode496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length-1;i >= 0; i--){
            int num = nums2[i];
            while(!stack.isEmpty()&&num>=stack.peek()){
                stack.pop();
            }
            map.put(num,stack.isEmpty()?-1:stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
