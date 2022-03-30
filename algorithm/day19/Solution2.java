package qrxedu.algorithm.day19;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int cnt = 1;
        StringBuffer s = new StringBuffer();
        for(int i = 0; i < str.length(); i++){
            if(i+1 < str.length() && str.charAt(i) == str.charAt(i+1)){
                cnt++;
                continue;
            }
            if(cnt != 1){
                s.append(cnt);
            }
            s.append(str.charAt(i));
            cnt = 1;
        }
        System.out.println(s);
    }
    @Test
    public void show(){
        List<Integer> list = new ArrayList<>(1);

    }
}
