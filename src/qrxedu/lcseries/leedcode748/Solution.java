package qrxedu.lcseries.leedcode748;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 * 大写字母就加32,空格和数字删掉
 */
public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        StringBuilder sb = new StringBuilder(licensePlate);
        int i = 0;
        while(i < sb.length()){
            if(sb.charAt(i)==' '||(sb.charAt(i)>='0'&&sb.charAt(i)<='9')){
                sb.deleteCharAt(i);
            }else{
                i++;
            }
        }
        char[] chars = sb.toString().toCharArray();
        for(int j = 0; j < chars.length;j++){
            if(chars[j] >= 'A'&&chars[j]<='Z'){
                chars[j]+=32;
            }
        }
        String out = "";
        int[] a = new int[26];
        for(int j = 0; j < chars.length;j++){
            a[chars[j]-'a']++;
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < words.length;j++){
            int[] b = new int[26];
            for(int k = 0; k < words[j].length();k++){
                b[words[j].charAt(k)-'a']++;
            }
            if(isTrue(a,b)){
                if(min > words[j].length()){
                    min = words[j].length();
                    out = words[j];
                }
            }
        }
        return out;
    }
    public boolean isTrue(int[] a,int[] b){
        for(int i = 0; i < a.length;i++){
            if(a[i] > b[i]){
                return false;
            }
        }
        return true;
    }
    @Test
    public void show(){
        String s = "1s3 PSt";
        String[] words = {"step", "steps", "stripe", "stepple"};
        System.out.println(shortestCompletingWord(s,words));
    }
}
