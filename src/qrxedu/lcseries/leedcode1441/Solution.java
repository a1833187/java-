package qrxedu.lcseries.leedcode1441;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<String> buildArray(int[] target, int n) {
        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        int count = 1;
        for(int i = 0; i < target.length; i++){
            if(count == target[i]){
                list.add("push");
            }else{
                list.add("push");
                list.add("pop");
                i--;
            }
            count++;
        }
        return list;
    }
}
