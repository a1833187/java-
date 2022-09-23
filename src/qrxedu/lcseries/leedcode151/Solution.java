package qrxedu.lcseries.leedcode151;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 1 && s.charAt(0) != ' '){
            return s;
        }
        char[] arr = s.toCharArray();
        List<Character> list = new ArrayList<>();
        int len = arr.length;
        int left = len - 1, right = len -1;
        while(left > 0){
            while(right >= 0 && arr[right] == ' '){
                right--;
            }
            left = right;
            while(left >= 0 && arr[left] != ' '){
                left--;
            }
            left++;
            for(int i = left; i <= right; i++){
                list.add(arr[i]);
            }
            list.add(' ');
            right = left - 1;
        }
        int k = 0;
        for(int i = list.size() - 1; i >= 0; i--){
            if(list.get(i) != ' '){
                k = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character i : list){
            sb.append(i);
        }
        sb.delete(k+1,sb.length());
        return new String(sb);
    }
    @Test
    public void show(){
        String s = "   the";
        System.out.println(reverseWords(s));
    }
}
