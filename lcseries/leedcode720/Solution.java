package qrxedu.leedcode720;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String longestWord(String[] words) {
        if(words == null || words.length == 0){
            return null;
        }
       Arrays.sort(words, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               if(o1.length() == o2.length()){
                   return o2.compareTo(o1);
               }
               return o1.length()-o2.length();
           }
       });
        String maxLen = "";
        Set<String> set = new HashSet<>();
        for(int i = 0; i < words.length;i++){
            if(words[i].length() == 1){
                set.add(words[i]);
                maxLen = words[i];
            }else if(set.contains(words[i].substring(0,words[i].length()-1))){
                set.add(words[i]);
                maxLen = words[i];
            }
        }
        return maxLen;
    }
}
