package qrxedu.Io;

import java.io.File;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Demo2 {
    public static void main(String[] args) {
        File f = new File("f:/a/aa.txt");
        System.out.println(f.exists());
        System.out.println(f.isDirectory());
        System.out.println(f.isFile());
        System.out.println("=================");
        File f1 = new File("./aa.txt");
        //这里文件不存在 .表示的是当前的目录:f:/leedcodeday为基准路径
        System.out.println(f1.getName());
        System.out.println(f1.exists());
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());
    }
}
