package qrxedu.Io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Demo6 {
    public static void main(String[] args) {
        try(Writer writer = new FileWriter("./aa.txt")){
            writer.write("hhh");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
