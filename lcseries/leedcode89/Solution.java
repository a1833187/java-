package com.qrxedu.lcseries.leedcode89;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 将满足条件的分序列首尾翻转后衔接到原有序列，然后将翻转后的序列追加1(在二进制表示中的最左侧追加1)
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<Integer> grayCode(int n) {
       List<Integer> list = new ArrayList<>();
       list.add(0);
       for(int i = 1; i <= n;i++){
           int m = list.size();
           for(int j = m-1; j >= 0; j--){
               list.add(list.get(j)|1<<(i-1));
           }
       }
       return list;
    }
    public void hs(List<Integer> list,int len,int i,int[] arr){
        if(i == len){
            return;
        }
        for(int j = 0; j < len; j++){
            if(!list.contains(j)&&isMatch(list.get(i),j)){
                if(i == len - 1){
                    if(!list.contains(j)&&isMatch(list.get(0),j)){
                        list.add(j);
                        arr[0]++;
                        hs(list,len,i+1,arr);
                    }else{
                        list.remove(i);
                        arr[0] = 0;
                    }
                }else {
                    list.add(j);
                    arr[0]++;
                    hs(list, len, i + 1,arr);
                }
            }
        }
        if(arr[0] == 0){
            list.remove(i);
        }
    }
    public boolean isMatch(int n1,int n2){
        int n3 = n1 ^ n2;
        Stack<Integer> stack = new Stack<>();
        while(n3!=0){
            if(n3%2!=0){
                stack.push(n3%2);
            }
            n3 = n3 / 2;
        }
        if(stack.size() == 1){
            return true;
        }else{
            return false;
        }
    }
    @Test
    public void show(){
        System.out.println(grayCode(3));
    }
}
