package qrxedu.leedcode953;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        for(int i = 0; i < n - 1; i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int l1 = s1.length();
            int l2 = s2.length();
            int j = 0;
            int ans = 0;
            while(j < Math.min(l1,l2)){
                ans = order.indexOf(s1.charAt(j)) - order.indexOf(s2.charAt(j));
                if(ans == 0){
                    j++;
                }else if(ans < 0){
                    break;
                }else{
                    return false;
                }
            }
            if(ans == 0 && l1 > l2){
                return false;
            }
        }
        return true;
    }
}
