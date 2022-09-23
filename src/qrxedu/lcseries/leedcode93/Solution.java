package qrxedu.lcseries.leedcode93;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    List<String> arr;
    int count = 0;
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        arr = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s,0,list);
        return list;
    }
    public void dfs(String s,int start,List<String> list){
        if(count == 4){
            if(start >= s.length()){
                StringBuffer sb = new StringBuffer();
                for(int i = 0; i < arr.size()-1;i++){
                    sb.append(arr.get(i));
                }
                list.add(new String(sb));
            }
            return;
        }
        for(int i = start; i < s.length();i++){
                if(isValid(s.substring(start,i+1))){
                    arr.add(s.substring(start,i+1));
                    arr.add(".");
                    count++;
                    dfs(s,i+1,list);
                    count--;
                    arr.remove(arr.size()-1);
                    arr.remove(arr.size()-1);

            }
        }
    }
    public boolean isValid(String str){
        if(str.length() == 1){
            return true;
        }
        if(str.length()>=1 && str.charAt(0) == '0'){
            return false;
        }
        if(str.length() > 3){
            return false;
        }
        int i = Integer.parseInt(str);
        return i >=0 && i <= 255;
    }
    @Test
    public void show(){
        System.out.println(restoreIpAddresses("101023"));
    }

}
