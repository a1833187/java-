package qrxedu.Io;

import jdk.nashorn.internal.ir.CatchNode;

import java.io.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Demo4 {
    public static void main(String[] args) {
        //每次按照写操作 打开文件都会自动清空文件旧有的内容，然后按照起始位置写
        try(OutputStream outputStream = new FileOutputStream("./aa.txt")){
            byte[] buffer = {95,96,97,98,99};
            outputStream.write(buffer);
            outputStream.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }

        try(OutputStream outputStream = new FileOutputStream("./aa.txt")) {
            try(OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"utf-8")){
                try(PrintWriter printWriter = new PrintWriter(outputStreamWriter)){
                    printWriter.println("aaaa");
                    printWriter.print("哈哈");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
