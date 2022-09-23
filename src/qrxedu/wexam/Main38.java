package qrxedu.wexam;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
             map.get(ch).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ch,list);
            }
        }
        Set<Character> set = map.keySet();
        int f = s.length();
        for(char ch : set){
            if(map.get(ch).size() == 1){
                f = Math.min(f,map.get(ch).get(0));
            }
        }
        if(f >= s.length()){
            System.out.println(-1);
        }else{
            System.out.println(s.charAt(f));
        }

    }
}
