package qrxedu.algorithm.day17.one;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<String> letterCombinations(String digits){
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        if(digits.length() == 0){
            return list;
        }
        dfs(sb,digits,0,list,map);
        return list;
    }
    public void dfs(StringBuilder sb,String digits,int index,List<String> list,Map<Character,String> map){
        if(index == digits.length()){
           String s = new String(sb);
           list.add(s);
           return;
        }
        String str = map.get(digits.charAt(index));
        for(int i = 0; i < str.length();i++){
            sb.append(str.charAt(i));
            dfs(sb,digits,index+1,list,map);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    @Test
    public void show(){
        System.out.println(letterCombinations("234"));
    }
}
