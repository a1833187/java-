package qrxedu.Io;

import java.io.*;
import java.util.Scanner;

/**
 * 复制文件
 * @author qiu
 * @version 1.8.0
 */
public class Demo8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要拷贝的源路径:");
        String src = scanner.next();
        System.out.println("请输入要拷贝的目标路径:");
        String dest = scanner.next();
        File file = new File(src);
        if(!file.isFile()){
            System.out.println("源路径输入有误");
            return;
        }
        try(InputStream inputStream = new FileInputStream(src)){
         try(OutputStream outputStream = new FileOutputStream(dest)){
             byte[] buffer = new byte[1024];
             while(true){
                 int len = inputStream.read(buffer);
                 if(len == -1){
                     break;
                 }
                 outputStream.write(buffer,0,len);
             }
         }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
