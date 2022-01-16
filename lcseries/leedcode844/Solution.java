package com.qrxedu.lcseries.leedcode844;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder tb = new StringBuilder(t);
        int index1 = 0;
        int index2 = 0;
        while(index1 != sb.length()){
            if(index1 == 0&&sb.charAt(index1) == '#'){
                sb.deleteCharAt(index1);
            }else if(sb.charAt(index1) == '#'){
                sb.deleteCharAt(index1);
                sb.deleteCharAt(index1-1);
            }else{
                index1++;
            }
        }
        while(index2 != tb.length()){
            if(index2 == 0&&tb.charAt(index2) == '#'){
                tb.deleteCharAt(index2);
            }else if(tb.charAt(index2) == '#'){
                tb.deleteCharAt(index2);
                tb.deleteCharAt(index2-1);
            }else{
                index2++;
            }
        }
        return sb.toString().equals(tb.toString());
    }
}
