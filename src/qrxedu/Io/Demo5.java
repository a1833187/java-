package qrxedu.Io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Demo5 {
    public static void main(String[] args) {
        try(Reader reader = new FileReader("./aa.txt")){
            char[] buffer= new char[1024];
            while(reader.read(buffer) != -1){
                System.out.println(buffer);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        try(Reader reader = new FileReader("./aa.txt")){
            while(true){
                int c = reader.read();
                if(c == -1){
                    break;
                }
                System.out.print((char)c);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
