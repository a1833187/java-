package qrxedu.lcseries.leedcode205;

import java.util.HashMap;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int n = s.length();
        HashMap<Character,Character> map = new HashMap<>();
        HashMap<Character,Character> map1 = new HashMap<>();
        for(int i = 0; i < n; i++){
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            if(map.containsKey(chS)){
                if(map.get(chS) != chT){
                    return false;
                }
            }else{
                map.put(chS,chT);
            }
            if(map1.containsKey(chT)){
                if(map1.get(chT) != chS){
                    return false;
                }
            }else{
                map1.put(chT,chS);
            }
        }
        return true;
    }
}
