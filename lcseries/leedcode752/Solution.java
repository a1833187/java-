package qrxedu.leedcode752;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadDict = new HashSet<>();
        for(String str:deadends){
            deadDict.add(str);
        }
        if(deadDict.contains("0000")){
            return -1;
        }
        int res = 0;
        int[] trans = {1,-1};
        Queue<String> queue = new LinkedList<>();
        Set<String> isVisited = new HashSet<>();
        String start = "0000";
        queue.offer(start);
        isVisited.add(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size != 0){
                String str = queue.peek();
                if(str.equals(target)){
                    return res;
                }
                for(int i = 0; i < 4; i++){
                    for(int j = 0; j < 2; j++){
                        char[] arr = str.toCharArray();
                        int k = (arr[i] - '0' + trans[j]) == -1 ? 9 : arr[i] - '0' + trans[j];
                        arr[i] = (char)((k)%10 + '0');
                        if(!deadDict.contains(new String(arr)) && !isVisited.contains(new String(arr))){
                            queue.offer(new String(arr));
                            isVisited.add(new String(arr));
                        }
                    }
                }
                queue.poll();
                size--;
            }
            res++;
        }
        return -1;
    }
    @Test
    public void show(){
        String[] d = {"8888"};
        String target = "0009";
        System.out.println(openLock(d,target));
    }
}
