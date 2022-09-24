package JavaSe_exam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.next();
            System.out.println(getString(s));
        }
    }
    public static String getString(String s){
        StringBuilder o = new StringBuilder();
        o.append(s.charAt(0));
        int i;
        char ch = ' ';
        int index = 1;
        while(true){
            ch = s.charAt(index);
            for(i = 0; i < o.length(); i++){
                if(ch == o.charAt(i)){
                    break;
                }
            }
            if( i == o.length()){
                o.append(ch);
            }
            if(index == s.length() - 1){
                break;
            }
            index++;
        }
        return o.toString();
    }
}
