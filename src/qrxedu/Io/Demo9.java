package qrxedu.Io;

import java.io.*;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Demo9 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入待扫描的源路径：");
        String src = scanner.next();
        System.out.println("请输入文件中的关键词");
        String key = scanner.next();
        File srcFile = new File(src);
        if(!srcFile.isDirectory()){
            System.out.println("输入的扫描路径有误");
            return;
        }
        scanFile(srcFile,key);
    }
    public static void scanFile(File file,String key) throws IOException {
        File[] files = file.listFiles();
        if(files == null){
            return;
        }
        for(File f : files){
            if(f.isFile()){
                if(containsKey(f,key)){
                    System.out.println(f.getCanonicalPath());
                }
            }else if(f.isDirectory()){
                scanFile(f,key);
            }
        }
    }
    public static boolean containsKey(File f,String key){
        StringBuilder stringBuilder = new StringBuilder();
        try(Reader reader = new FileReader(f)){
          char[] ch = new char[1024];
          while(true){
              int len = reader.read(ch);
              if(len == -1){
                  break;
              }
              stringBuilder.append(new String(ch,0,len));
          }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //stringBuilder.indexOf(key) 返回stringBuilder中key首次出现的起始位置
        return new String(stringBuilder).contains(key);
    }
}
