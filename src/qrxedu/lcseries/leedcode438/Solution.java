package qrxedu.lcseries.leedcode438;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        System.out.println(findAnagrams(s,p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        //超时，，
        if(s.equals(p)){

        }
        List<Integer> list1 = new ArrayList<>();
        for(int i = 0; i <= s.length()-p.length();i++){
            if(isContain(s.substring(i,i+p.length()),p)){
                list1.add(i);
            }
        }
        return list1;
    }
    public static List<String> listAll(String p){
        //求出一个没有重复元素的字符串的所有排列组合
        int len = factorial(p.length());
        List<String> list = new ArrayList<>();
        Random random  = new Random();
        while(list.size()<len){
            StringBuilder sb = new StringBuilder(p);
            StringBuilder tmp = new StringBuilder();
            while(sb.length()!=0) {
                int i = random.nextInt(sb.length());
                tmp.append(sb.charAt(i));
                sb.deleteCharAt(i);
            }
            if(!list.contains(tmp.toString())){
                list.add(tmp.toString());
            }
        }
        return list;
    }
    public static boolean isContain(String s,String p){
        StringBuilder ss = new StringBuilder(s);
        StringBuilder sp = new StringBuilder(p);
        if(ss.length()!=sp.length()){
            return false;
        }
        int i = 0;
        int j = 0;
        for(i = 0; i< s.length();i++){
            for(j = 0; j < sp.length(); j++){
               if(ss.charAt(i) == sp.charAt(j)){
                   sp.deleteCharAt(j);
                   break;
               }
            }
        }
        if(sp.length() == 0){
            return true;
        }else{
            return false;
        }
    }
    public static int factorial(int n){
        if(n==1){
            return n;
        }
        return n*factorial(n-1);
    }

    /*滑动窗口求解
     int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
     */
}
