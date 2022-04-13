package qrxedu.leedcode87;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 扰乱字符串
 * 动态规划的问题状态的寻找依赖于  如何把一个大问题分解成 完全类似的子问题.
 * 状态的确定的思路:
 * 1.假设大问题的解已知,那么那些子问题的解和这个类似?(判断型dp:一个大问题要是true那么他的每一个子问题
 * 很大可能也都是true,你比如说判断一个字符串是否是回文?)
 * 2.假设子问题的解已知,那么这个子问题对于大问题有什么影响(寻找最优解)?
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Solution {
    public int[][][] f = new int[50][50][50];
    public String s1;
    public String s2;
    public boolean isScramble(String s1, String s2){
        this.s1 = s1;
        this.s2 = s2;
        int length = s1.length();
        return dfs(0,0,length);
    }
    public boolean dfs(int l1,int l2,int length){
        if(f[l1][l2][length] != 0){
            return f[l1][l2][length] == 1;
        }
        if(s1.substring(l1,l1+length).equals(s2.substring(l2,l2+length))){
            f[l1][l2][length] = 1;
            return true;
        }
        if(!isValid(l1,l2,length)){
            f[l1][l2][length] = -1;
            return false;
        }
        for(int i = 1; i < length; i++){
            if(dfs(l1,l2,i) && dfs(l1+i,l2+i,length-i)){
                f[l1][l2][length] = 1;
                return true;
            }
            if(dfs(l1,l2+length-i,i) && dfs(l1+i,l2,length-i)){
                f[l1][l2][length] = 1;
                return true;
            }
        }
        f[l1][l2][length] = -1;
        return false;

    }
    public boolean isValid(int l1,int l2, int length){
        Map<Character,Integer> map = new HashMap<>();
        for(int i = l1; i < l1+ length; i++){
            char ch = s1.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(int i = l2; i < l2 + length; i++){
            char ch = s2.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)-1);
        }
        Set<Character> set = new HashSet<>();
        for(char ch : set){
            if(map.get(ch) != 0){
                return false;
            }
        }
        return true;
    }












   /*
    public boolean flag = false;
    public String s;
    public String t;
    //模拟搜索TL 了
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        s = s1;
        t = s2;
        //首先先将字符串分成两部分
        twoSearch(s,0,s.length()-1);
        return flag;
    }
    public void twoSearch(String str,int left,int right){
        if(str.equals(t)){
            flag = true;
            return;
        }
        if(left < right){
            for(int i = left; i < right; i++){
                twoSearch(str,left,i);
                twoSearch(str,i+1,right);
                String newStr = reverse(str,left,i,right);
                twoSearch(newStr,left,right+left-i-1);
                twoSearch(newStr,right+left-i,right);
            }
        }
    }
    public String reverse(String str,int left,int mid,int right){
        String l = str.substring(left,mid+1);
        String r = str.substring(mid+1,right+1);
        String ll = str.substring(0,left);
        String rr = str.substring(right+1,str.length());
        return ll + r + l +rr;
    }*/
    @Test
    public void show(){
        String s1 = "abcdbdacbdac";
        String s2 = "bdacabcdbdac";
        System.out.println(isScramble(s1,s2));
    }
}
