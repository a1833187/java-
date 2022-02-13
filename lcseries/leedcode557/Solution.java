package qrxedu.leedcode557;

import org.junit.jupiter.api.Test;

/**
 * 反转字符串：不要用len - 1 - j
 * 用双指针分别从头尾开始往中间走，每走一次，交换一次。这样写不容易乱
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String reverseWords(String s) {
        char[] ss = s.toCharArray();
        int i = 0, j = 0;
        int len = ss.length;
        while(j < len){
            i = j;
            while(j < len && ss[j] != ' '){
                j++;
            }
            reverse(ss,i,j-1);
            j++;
        }
        return new String(ss);
    }
    public void reverse(char[] arr,int i,int j){
        while(i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    @Test
    public void show(){
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
