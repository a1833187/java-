package qrxedu.Io;

import java.io.File;
import java.util.Scanner;

/**
 * 给定目录 和待删除的文件名(包含关系)，当找到待删除的文件时需要进行判断是否一定删除
 * @author qiu
 * @version 1.8.0
 */
public class Demo7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的路径：");
        String directory = scanner.next();
        System.out.println("请输入要删除的文件名");
        String file = scanner.next();
        File file1 = new File(directory);
        if(!file1.isDirectory()){
            System.out.println("输入的扫描路径有误");
            return;
        }
        //遍历该目录下的所有普通文件和子目录，递归遍历N叉树
        deleteFile(file1,file);
    }
    public static void deleteFile(File directory,String deleteName){
        if(directory == null){
            return;
        }
        File[] files = directory.listFiles();
        if(files == null){
            return;
        }
        for(int i = 0; i < files.length; i++){
            if(files[i].isFile()){
                if(files[i].getName().contains(deleteName)){
                    deleteComFile(files[i]);
                }
            }else if(files[i].isDirectory()){
                deleteFile(files[i],deleteName);
            }
        }
    }
    public static void deleteComFile(File file){
        Scanner scanner = new Scanner(System.in);
        System.out.println(file.getAbsoluteFile() + "确认要删除吗(y/n):");
        char ch = scanner.next().charAt(0);
        if(ch == 'y'){
            file.delete();
            System.out.println("文件删除成功");
        }else{
            System.out.println("取消删除文件");
        }
    }
}
