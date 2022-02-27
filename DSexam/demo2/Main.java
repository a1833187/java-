package qrxedu.demo2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        while(scanner.hasNextLine()){
            String n = scanner.nextLine();
            list.add(n);
        }
        for(int i = 0; i < list.size(); i++){
            String str = list.get(i);
            int k = 0;
            for(int j = 0; j < str.length(); j++){
                if(j > 0 && str.charAt(j) == ' ' && str.charAt(j-1) != ' '){
                    set.add(str.substring(k,j));
                    k = j + 1;
                }
                if(j == str.length() - 1){
                    set.add(str.substring(k,j+1));
                }
            }
        }
        System.out.println(set.size());
    }
}
