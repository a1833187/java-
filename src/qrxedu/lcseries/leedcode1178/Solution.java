package qrxedu.lcseries.leedcode1178;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Java中计算一个数n的二进制有多少位的函数:Integer.bitCount(n)
 * 统计一个二进制集合(压缩形式)mask的子集的代码: ┭┮﹏┭┮太秀了.
 * int cur = mask;
 * while(cur != 0){
 *     //对cur进行一顿操作;
 *     //这种方式可以有效去除掉cur某一位上为1,mask某一位上为0的集合.
 *     cur = (cur - 1) & mask;
 * }
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer,Integer> dict = new HashMap<>();
        for(String word : words){
            int n = word.length();
            int mask = 0;
            for(int i = 0; i < n; i++){
                char ch = word.charAt(i);
                mask |= 1<<(ch-'a');
            }
            if(Integer.bitCount(mask) <= 7){
                dict.put(mask,dict.getOrDefault(mask,0)+1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(String puzzle : puzzles){
            int total = 0;
            int mask = 0;
            for(int i = 1; i < 7; i++){
                char ch = puzzle.charAt(i);
                mask |= (1 <<(ch - 'a'));
            }
            int cur = mask;
            do {
                int s = cur | (1 << (puzzle.charAt(0)-'a'));
                if(dict.containsKey(s)){
                    total+=dict.get(s);
                }
                cur = (cur - 1) & mask;
            }while(cur != mask);
            ans.add(total);
        }
        return ans;
    }
}
