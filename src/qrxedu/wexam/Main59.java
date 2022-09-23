package qrxedu.wexam;


import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main59 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.nextLine();
            String key = scanner.nextLine();
            int l = 0,n = str.length();
            boolean flag = false;
            while(l < n){
                if(str.charAt(l) == '"'){
                    int r = l+1;
                    while(r < n && str.charAt(r) != '"'){
                        r++;
                    }
                    if(str.substring(l+1,r).equals(key)){
                        System.out.println("Ignore");
                        flag = true;
                        break;
                    }
                    l = r + 2;
                }else{
                    int r = l + 1;
                    while(r < n && str.charAt(r) != ','){
                        r++;
                    }
                    if(str.substring(l,r).equals(key)){
                        System.out.println("Ignore");
                        flag = true;
                        break;
                    }
                    l = r + 1;
                }
            }
            if(!flag){
                System.out.println("Important");
            }
        }
    }
}
