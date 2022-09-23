package qrxedu.wexam;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main81 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            int i = s1[0].length()-1;
            while(i >= 0 && s1[0].charAt(i) != '\\'){
                i--;
            }
            i++;
            String cur;
            if(s1[0].length()-i<=16){
                cur = s1[0].substring(i,s1[0].length()) + " " + s1[1];
            }else{
                cur = s1[0].substring(s1[0].length()-16) + " " + s1[1];
            }
            if(map.containsKey(cur)){
                map.put(cur,map.get(cur)+1);
            }else{
                map.put(cur,1);
                list.add(cur);
            }
        }
        int n = list.size();
        int i = n <= 8 ? 0 : n-8;
        for(;i < n; i++){
            String o = list.get(i);
            Integer num = map.get(o);
            System.out.println(o + " " + num);
        }
    }
}
