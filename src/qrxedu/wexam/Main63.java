package qrxedu.wexam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main63 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int cnt = 0;
            int n = scanner.nextInt();
            Map<Character,String> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                char id = scanner.next().charAt(0);
                String con = scanner.next();
                if("connect".equals(con)){
                    if(cnt > map.size()){
                        map.put(id,con);
                    }else{
                        cnt++;
                        map.put(id,con);
                    }
                }else{
                    if(map.containsKey(id)){
                        map.remove(id);
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
