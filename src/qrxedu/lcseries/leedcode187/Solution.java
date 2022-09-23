package qrxedu.lcseries.leedcode187;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String,Integer> hashMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        int i;
        for(i = 0; i <= s.length()-10;i++){
            hashMap.put(s.substring(i,i+10),hashMap.getOrDefault(s.substring(i,i+10),0)+1);
            if(hashMap.get(s.substring(i,i+10)) == 2){
                list.add(s.substring(i,i+10));
            }
        }

        return list;
    }
}
