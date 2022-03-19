import com.sun.applet2.AppletParameters;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            long x = scanner.nextLong();
            map.put(x,map.getOrDefault(x,0) +1);
        }
        for(int i = 0; i < q; i++){
            long x = scanner.nextLong();
            if(map.containsKey(x)){
                System.out.println(map.get(x));
            }else{
                System.out.println(-1);
            }
        }
    }
}
