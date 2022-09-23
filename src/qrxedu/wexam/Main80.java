package qrxedu.wexam;

import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main80 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strs = new String[n];
        for(int i = 0; i < n; i++){
            strs[i] = scanner.next();
        }
        String key = scanner.next();
        int k = scanner.nextInt();
        List<String> list = new ArrayList<>();
        int[] cnt = new int[26];
        for(int i = 0; i < key.length(); i++){
            cnt[key.charAt(i)-'a']++;
        }
        for(int i = 0; i < n; i++){
            if(strs[i].equals(key)){
                continue;
            }
            int[] cur = new int[26];
            for(int j = 0; j < strs[i].length(); j++){
                cur[strs[i].charAt(j)-'a']++;
            }
            boolean flag = true;
            for(int j = 0; j < 26; j++){
                if(cnt[i] != cur[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                list.add(strs[i]);
            }
        }
        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
        System.out.println(list.size());
        if(k <= list.size()) {
            System.out.println(list.get(k - 1));
        }
    }
}
