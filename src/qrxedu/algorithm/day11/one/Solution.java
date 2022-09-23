package qrxedu.algorithm.day11.one;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean wordBreak(String str,String[] dir){

        boolean[] canBreak = new boolean[str.length()+1];
        canBreak[0] = true;
        for(int i = 0;i<str.length();i++){
            for(int k = 0;k <= i;k++){
                if(canBreak[k] && isContains(str.substring(k,i+1),dir)){
                    canBreak[i+1] = true;
                    break;
                }
            }
        }
        return canBreak[str.length()];
    }
    public boolean isContains(String str,String[] dir){
        for (String s : dir) {
            if (str.equals(s)) {
                return true;
            }
        }
        return false;
    }

}
