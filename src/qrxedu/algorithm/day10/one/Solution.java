package qrxedu.algorithm.day10.one;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String reverseSentence(String str){
        if(str == null || str.length() == 0){
            return str;
        }
        char[] chars = str.toCharArray();
        int len = str.length();
        int i = 0;
        int j = i;
        while(i < len){
            while(i<len && chars[i]!= ' '){
                i++;
            }
            Reverse(chars,j,i-1);
            while(i < len && chars[i] == ' '){
                i++;
            }
            j = i;
        }
        Reverse(chars,j,i-1);
        Reverse(chars,0,len-1);
        return new String(chars);
    }
    public void Reverse(char[] chars,int i,int j){
        for(int l = i;l<(j+i)/2;l++){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
    }

}
