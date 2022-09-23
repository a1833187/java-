package qrxedu.offer;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
       Set<Character> set = new HashSet<>();
       int r = -1,ans = 0;
       int n = s.length();
       for(int i = 0; i < n; i++){
           if(i != 0){
               set.remove(s.charAt(i-1));
           }
           while(r+1<n && !set.contains(s.charAt(r+1))){
               set.add(s.charAt(r+1));
               r++;
           }
           ans = Math.max(ans,r-i+1);
       }
       return ans;
    }
    @Test
    public void show(){
        System.out.println(lengthOfLongestSubstring("abc"));
    }
}
