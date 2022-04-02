package qrxedu.wexam;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 *  next 和 nextLine 的区别：
 *  next：在读到除空格、Tab、回车之外的字符才算成功读取，成功读取后，遇到空格、Tab或回车就会停止读取
 *  nextLine:只有回车键被当作结束符，且不考虑成功读取，读取的字符串中可以包含空格。需要注意的是当nextLine
 *  前面有其他的输入时(如nextInt等)，这时从上一个输入过渡到nextLine时的回车会被当作第一个nextLine的结束符。
 *  所以再必须用nextLine时，遇见这种情况要多输入一个nextLine
 * @author qiu
 * @version 1.8.0
 */
public class Main10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strs = new String[n];
        for(int i = 0; i < n; i++){
            strs[i] = scanner.next();
        }
        boolean flag1 = true;
        boolean flag2 = true;
        for(int i = 0; i < n-1; i++){
            if(strs[i].length() > strs[i+1].length()){
                flag1 = false;
            }
            if(strs[i+1].compareTo(strs[i])<0){
                flag2 = false;
            }
        }
        if(flag1 && flag2){
            System.out.println("both");
        }else if(flag1){
            System.out.println("lengths");
        }else if(flag2){
            System.out.println("lexicographically");
        }else{
            System.out.println("none");
        }
    }
    @Test
    public void show(){
      Scanner scanner = new Scanner(System.in);
      String str = scanner.nextLine();
        System.out.println(str);
    }
}
