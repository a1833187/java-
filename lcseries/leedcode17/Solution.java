package qrxedu.leedcode17;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    StringBuffer str;
    List<String> list;
    public List<String> letterCombinations(String digits) {
         list = new ArrayList<>();
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        for (int i = 0; i < digits.length(); i++) {
            getList(digits.charAt(i), list);
        }
        str = new StringBuffer();
        int len = list.size();
        dfs(0,list,res);
        return res;
    }
    public void dfs(int index,List<String> list,List<String> res){
        if(index == list.size()){
            if(str.length() == list.size()){
                res.add(str.toString());
            }
            return;
        }
        for(int i = 0; i < list.get(index).length();i++){
            char c = list.get(index).charAt(i);
            str.append(c);
            dfs(index+1,list,res);
            str.delete(str.length()-1,str.length());
        }
    }
    @Test
    public void show(){
        System.out.println(letterCombinations("23"));
    }
    public void func(List<String> res, List<String> list) {
        switch (list.size()) {
            case 1: {
                for (int i = 0; i < list.get(0).length(); i++) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(list.get(0).charAt(i));
                    res.add(new String(sb));
                }
                break;
            }
            case 2: {
                for(int i = 0; i < list.get(0).length();i++){
                    for(int j = 0; j < list.get(1).length();j++){
                        StringBuffer sb = new StringBuffer();
                        sb.append(list.get(0).charAt(i));
                        sb.append(list.get(1).charAt(j));
                        res.add(new String(sb));
                    }
                }
                break;
            }
            case 3: {
                for(int i = 0; i < list.get(0).length();i++){
                    for(int j = 0; j < list.get(1).length();j++){
                        for(int k = 0; k < list.get(2).length();k++){
                            StringBuffer sb = new StringBuffer();
                            sb.append(list.get(0).charAt(i));
                            sb.append(list.get(1).charAt(j));
                            sb.append(list.get(2).charAt(k));
                            res.add(new String(sb));
                        }
                    }
                }
                break;
            }
            case 4: {
                for(int i = 0; i < list.get(0).length();i++){
                    for(int j = 0; j < list.get(1).length();j++){
                        for(int k = 0; k < list.get(2).length();k++){
                            for(int l = 0; l < list.get(3).length();l++) {
                                StringBuffer sb = new StringBuffer();
                                sb.append(list.get(0).charAt(i));
                                sb.append(list.get(1).charAt(j));
                                sb.append(list.get(2).charAt(k));
                                sb.append(list.get(3).charAt(l));
                                res.add(new String(sb));
                            }
                        }
                    }
                }
                break;
            }
        }
    }

    public void getList(char c, List<String> list) {
        switch (c) {
            case '2': {
                list.add("abc");
                break;
            }
            case '3': {
                list.add("def");
                break;
            }
            case '4': {
                list.add("ghf");
                break;
            }
            case 5: {
                list.add("jki");
                break;
            }
            case 6: {
                list.add("mno");
                break;
            }
            case 7: {
                list.add("pqrs");
                break;
            }
            case '8': {
                list.add("tuv");
                break;
            }
            case '9': {
                list.add("wxyz");
                break;
            }
        }
    }
}
