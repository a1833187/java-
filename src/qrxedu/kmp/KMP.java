package qrxedu.kmp;

import java.util.HashMap;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
/**
 * KMP 关键是next数组的求法。
 * KMP算法相较于BF暴力算法而言，其优化的地方在于当匹配失败时，主串的字符不会回退，而子串的字符不会一个一个回退
 * 当str和sub匹配到某个字符发生匹配失败时,sub中的指针会退回到某个具体的位置,使得sub[0~k-1] == sub[i-k,i-1],k = next[i]
 * 而当sub[k] == sub[i]时,next[i+1] = next[i] + 1;
 * 当sub[k] != sub[i]时,我们需要将i退回到next[i]，然后继续求直到sub[k] = sub[i] ,k = next[i]
 */
public class KMP {
    static public void getNext(int[] next,String sub){
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        while(i < sub.length()){
            int j = i - 1;
            while(next[j] >= 0 && sub.charAt(i-1) != sub.charAt(next[j])){
                j = next[j];
                if(j == -1){
                    break;
                }
            }
            if(next[j] == -1 || sub.charAt(i-1) == sub.charAt(next[j])){
                next[i] = next[j] + 1;
            }
            i++;
        }
    }
    static public int kmp(String str,String sub,int pos){
        if(str == null || sub == null){
            return -1;
        }
        int strLen = str.length();
        int subLen = sub.length();
        if(strLen == 0 || subLen == 0){
            return -1;
        }
        if(pos < 0 || pos >= subLen){
            return -1;
        }
        int[] next = new int[subLen];
        getNext(next,sub);
        int i = 0;
        int j = pos;
        while(i < strLen && j < subLen){
            if(j == -1 || str.charAt(i) == sub.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j >= subLen){
            return i - j;
        }
        //走到这说明在str中没有子串和sub相等。
        return -1;
    }

    public static void main(String[] args) {
        /*String str = "abcabcabcd";
        String sub = "efg";
        System.out.println(kmp(str,sub,0));*/
    }
}