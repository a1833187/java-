package qrxedu.wexam;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            String[] strs = new String[n];
            for(int i = 0; i < n; i++){
                strs[i] = scanner.next();
            }
            //字符串数组默认按照字典序排列
            Arrays.sort(strs);
            boolean[] flag = new boolean[n];
            Arrays.fill(flag,true);
            //这里只能和最近的后面一个比较.不能和再往后的字符串比较(没有搞清楚为啥...)
            for(int i = 0; i < n - 1; i++){
                String si = strs[i];
                String sj = strs[i+1];
                if(si.equals(sj)){
                    flag[i] = false;
                }else if(sj.length() >= si.length() && si.equals(sj.substring(0,si.length()))
                        && sj.charAt(si.length()) == '/'){
                    flag[i] = false;
                }
            }
            for(int i = 0; i < n; i++){
                if(flag[i]){
                    System.out.println("mkdir -p " + strs[i]);
                }
            }
            System.out.println();
        }
    }
    @Test
    public void show(){
        String[] strs = {"/a","/ab","/a/b"};
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
    }
}
