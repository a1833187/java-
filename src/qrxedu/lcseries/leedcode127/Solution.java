package qrxedu.lcseries.leedcode127;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 单词接龙
 * 有一个问题：String str = "abc",char[] arr = str.toCharArray(),
 * arr.toString().equals(str) // false 这个原因是arr.toString()调用的是Object方法，返回的是对应的"哈希值"
 * Arrays.toString(str).equals(str) // false 这个原因是Arrays.toString()返回的结果是 "[str]"而不是"str",这个方法只用来打印
 * new String(arr).equals(str) //true 改变字符串 --> 变成字符数组,改变字符数组中的某一个值 ---> 将字符数组通过new String()变为字符串
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();
        Set<String> dict = new HashSet<>();
        for(String str : wordList){
            dict.add(str);
        }
        queue.offer(beginWord);
        isVisited.add(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                String str = queue.peek();
                if(str.equals(endWord)){
                    return count;
                }
                for(int i = 0; i < str.length();i++){
                    char[] arr = str.toCharArray();
                    for(int j = 0; j < 26;j++){
                        arr[i] = (char)(j+'a');
                        if(dict.contains(new String(arr)) && !isVisited.contains(new String(arr))){
                            queue.offer(new String(arr));
                            isVisited.add(new String(arr));
                        }
                    }
                }
                queue.poll();
                size--;
            }
            count++;
        }
        return 0;
    }
    @Test
    public void show(){
        String beg = "hit";
        String end = "cog";
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(ladderLength(beg,end,list));
    }
}
