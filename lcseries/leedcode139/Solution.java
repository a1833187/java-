package qrxedu.leedcode139;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for(int i = 0; i < dp.length; i++){
            for(int k = i; k >= 0; k--){
                if(k == i && wordDict.contains(s.substring(0,i+1))){
                    dp[i] = true;
                    break;
                }
                if(dp[k] && wordDict.contains(s.substring(k+1,i+1))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()-1];
    }
    @Test
    public void show(){
        String s = "catsandog";
        List<String> list = new ArrayList<>();
        list.add("cats");
        list.add("sand");
        list.add("and");
        list.add("dog");
        list.add("cat");
        System.out.println(wordBreak(s,list));
    }
}
