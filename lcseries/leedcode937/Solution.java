package qrxedu.leedcode937;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> number = new ArrayList<>();
        List<String> letter = new ArrayList<>();
        for(String str: logs){
            int n = str.length();
            int i = 0;
            while(i < n && str.charAt(i) != ' '){
                i++;
            }
            i++;
            if(Character.isDigit(str.charAt(i))){
                number.add(str);
            }else{
                letter.add(str);
            }
        }
        letter.sort((o1, o2) -> {
            int i1 = getStr(o1);
            int i2 = getStr(o2);
            int ans = o1.substring(i1, o1.length()).compareTo(o2.substring(i2, o2.length()));
            if (ans != 0) {
                return ans;
            } else {
                return o1.substring(0, i1 - 1).compareTo(o2.substring(0, i2 - 1));
            }
        });
        String[] ans = new String[logs.length];
        int len = ans.length;
        int len1 = letter.size();
        int i = 0;
        for(;i < len1;i++){
            ans[i] = letter.get(i);
        }
        for(;i < len;i++){
            ans[i] = number.get(i-len1);
        }
        return ans;

    }
    public int getStr(String s){
        int n = s.length();
        int i = 0;
        while(i < n && s.charAt(i) != ' '){
            i++;
        }
        return i+1;

    }
}
