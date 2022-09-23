package qrxedu.lcseries.leedcode551;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean checkRecord(String s) {
       int countA = 0;
       int countL = 0;
       for(int i = 0; i < s.length(); i++){
           char ch = s.charAt(i);
           if(ch == 'A'){
               countA++;
           }
           if(ch == 'L'){
               if(i+2 < s.length() && s.charAt(i+1) == 'L' && s.charAt(i+2) == 'L'){
                   return false;
               }
           }
       }
       return countA < 2;
    }
}
