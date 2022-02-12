package qrxedu.leedcode0102;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        int[] count1 = new int[s1.length()];
        int[] count2 = new int[s2.length()];
        for(int i = 0; i < s1.length(); i++){
            count1[i] = s1.charAt(i);
            count2[i] = s2.charAt(i);
        }
        int max1 = count1[0];
        int max2 = count2[0];
        for(int i = 0; i < s1.length();i++){
            if(max1 < count1[i]){
                max1 = count1[i];
            }
            if(max2 < count2[i]){
                max2 = count2[i];
            }
        }
        if(max1 != max2){
            return false;
        }
        int[] res1 = new int[max1+1];
        int[] res2 = new int[max2+1];
        for(int i = 0; i < res1.length;i++){
            res1[count1[i]]++;
            res2[count2[i]]++;
        }
        for(int i = 0;i < res1.length;i++){
            if(res1[i] != res2[i]){
                return false;
            }
        }
        return true;
    }


}
