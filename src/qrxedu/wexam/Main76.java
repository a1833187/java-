package qrxedu.wexam;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main76 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Set<String> set = new TreeSet<>();
        dfs(n,m,1,set,new StringBuilder());
        for(String str : set){
            System.out.println(str);
        }
    }
    public static void dfs(int n,int m,int index,Set<String> set,StringBuilder str){
        if(index > n){
            if(m == 0){
                str.deleteCharAt(str.length()-1);
                String s = new String(str);
                set.add(s);
            }
            return;
        }
        StringBuilder cur = new StringBuilder(str);
        cur.append(index+" ");
        dfs(n,m-index,index+1,set,cur);
        dfs(n,m,index+1,set,str);
    }
}
