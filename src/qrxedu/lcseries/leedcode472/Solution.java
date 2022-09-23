package qrxedu.lcseries.leedcode472;

import java.util.Arrays;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    String[] dict;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int n = words.length;
        dict = Arrays.copyOf(words,n);
        Arrays.sort(dict, (o1, o2) -> o1.length() - o2.length());
        boolean[] isContact = new boolean[n];
        for(int i = 0; i < n; i++){
            boolean[] f = new boolean[words[i].length()];
            for(int j = 0; j < f.length; j++){

            }
        }
        return null;
    }
    public boolean isSame(int index,String str){
        for(int i = 0; i < index; i++){
            if(dict[i].equals(str)){
                return true;
            }
        }
        return false;
    }
}
