package qrxedu.Io;

import java.io.File;
import java.io.IOException;

/**
 * 扫描目标目录下哪些文件中有指定的关键词
 * 这种检索方式是比较低效的，在对很多文件或者大文件时要慎用
 * 要想让检索更高效，需要用到倒排索引(O(1))这样的数据结构，当前所用的数据结构是N叉树
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Demo1 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("F:/leedcodeday/src/qrxedu");
        System.out.println(file1.getParent());
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getCanonicalPath());
        File file2 = new File("./qrxedu");
        System.out.println("=========================");
        System.out.println(file2.getParent()); // 父目录
        System.out.println(file2.getName());  // 本文件的名字
        System.out.println(file2.getPath()); // 本文件的相对路径
        System.out.println(file2.getAbsolutePath()); // 绝对路径
        System.out.println(file2.getCanonicalPath()); // 绝对路径简化版
        //分隔符可以是'\' 也可以是 '/'，大多数操作系统都是用'/'分隔，'\'在编程时会发生字符转义之间的误会、
        //Windows由于历史遗留问题 导致输出的路径的分隔符 是'\',但兼容'/'
        System.out.println("=============================");
        File file3 = new File("./qiuruixiang.txt");
        System.out.println(file3.exists());
        file3.createNewFile();
        System.out.println(file3.exists());
        file3.delete();
        System.out.println("=================================");
        File file4 = new File("./aaa");
        file4.mkdir();
        System.out.println(file4.isDirectory());
        file4.delete();
        File file5 = new File("./aaa/abc/ccc/dde");
        file5.mkdirs();
        System.out.println(file5.isDirectory());
        file5.delete();

    }
}
