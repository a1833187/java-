package qrxedu.Io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Demo3 {
    public static void main(String[] args) throws FileNotFoundException {
       /* InputStream input = null;
        try {
            input = new FileInputStream("./aa.txt");
            byte[] bytes = new byte[1024];
            System.out.println(input.read(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        //try with resources，在try中创建对象，当对象实现了closeable接口时会隐式调用对象的close
        //所有流中都实现了closeable接口
        try(InputStream inputSteam = new FileInputStream("./aa.txt")){
            byte[] bytes = new byte[1024];
            int ans = inputSteam.read(bytes);

        }  catch (IOException e) {
            e.printStackTrace();
        }

        try(InputStream inputStream = new FileInputStream("./aa.txt")){
            while(true){
                int b = inputStream.read();
                if(b == -1){
                    break;
                }
                System.out.println(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(InputStream inputStream = new FileInputStream("./aa.txt")){
            try(Scanner scanner = new Scanner(inputStream,"utf-8")){
               while(scanner.hasNext()){
                   String s = scanner.next();
                   System.out.println(s);
               }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
