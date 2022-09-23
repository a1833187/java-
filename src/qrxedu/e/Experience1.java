package qrxedu.e;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Experience1 {
    public static void main(String[] args) {
        //读取文件并作初步分割
        String[] ins = getContent();
        int len = ins.length;
        Map<String,Integer> dict = new HashMap<>();
        for(String str : ins){
            dict.put(str,dict.getOrDefault(str,0)+1);
        }
        int size = dict.size();
        //内容分割
        String[][] input = new String[size][2];
        String[][] input1 = new String[size][2];
        Set<String> set = dict.keySet();
        int idx = 0;
        for(String str : set){
            input[idx][0] = str;
            input1[idx][0] = str;
            input[idx][1] = dict.get(str)+"";
            input1[idx][1] = dict.get(str)+"";
            idx++;
        }
        //单词排序
        mergeSortByL(input,1,size-1,0);
        mergeSortByL(input1,0,size-1,1);
        //结果输出
        int col = 0;
        System.out.println("按字母排序:");
        for(int i = 1; i < size; i++){
            col++;
            System.out.print(input[i][0] + ":" + input[i][1] + ",");
            if(col % 10 == 0){
                System.out.println();
            }
        }
        col =  0;
        System.out.println();
        System.out.println("======================");
        System.out.println("按单词频率降序排序");
        for(int i = size-1; i > 0; i--){
            col++;
            System.out.print(input1[i][0] + ":" + input1[i][1]+",");
            if(col % 10 == 0){
                System.out.println();
            }
        }
    }
    public static boolean myCompare(String s1,String s2){
        //true 为升序,false 为降序
        if(s1 == null){
            return true;
        }
        if(s2 == null){
            return false;
        }
        int len1 = s1.length();
        int len2 = s2.length();
        int len = Math.min(len1,len2);
        for(int i = 0; i < len; i++){
            if(s1.charAt(i) < s2.charAt(i)){
                return true;
            }else if(s1.charAt(i) > s2.charAt(i)){
                return false;
            }
        }
        return len1 < len2;
    }

    public static void mergeSortByL(String[][] arr,int left,int right,int type){
        if(left < right){
            int mid = left + right >> 1;
            mergeSortByL(arr,left,mid,type);
            mergeSortByL(arr,mid+1,right,type);
            String[][] arrL = new String[mid-left+1][2];
            String[][] arrR = new String[right-mid][2];
            for(int i = left; i <= mid; i++){
                arrL[i-left][0] = arr[i][0];
                arrL[i-left][1] = arr[i][1];
            }
            for(int i = mid+1; i <= right; i++){
                arrR[i - mid - 1][0] = arr[i][0];
                arrR[i - mid - 1][1] = arr[i][1];
            }
            String[][] arrC = mergeByL(arrL,arrR,type);
            for(int i = left; i <= right; i++){
                arr[i][0] = arrC[i-left][0];
                arr[i][1] = arrC[i-left][1];
            }
        }
    }
    public static String[][] mergeByL(String[][] arr1, String[][] arr2,int type){
        //0是按字母排序
        //1是按频率排序
        int l1 = arr1.length;
        int l2 = arr2.length;
        String[][] arr = new String[l1+l2][2];
        int index = 0;
        int i1= 0;
        int i2 = 0;
        if(type == 0){
            while(i1 < l1 && i2 < l2){
                if(myCompare(arr1[i1][0],arr2[i2][0])){
                    arr[index][0] = arr1[i1][0];
                    arr[index++][1] = arr1[i1++][1];
                }else{
                    arr[index][0] = arr2[i2][0];
                    arr[index++][1] = arr2[i2++][1];
                }
            }
        }else if(type == 1){
            while(i1 < l1 && i2 < l2){
                if(Integer.parseInt(arr1[i1][1]) < Integer.parseInt(arr2[i2][1])){
                    arr[index][0] = arr1[i1][0];
                    arr[index++][1] = arr1[i1++][1];
                }else{
                    arr[index][0] = arr2[i2][0];
                    arr[index++][1] = arr2[i2++][1];
                }
            }
        }
        if(i2 < l2){
            for(;i2 < l2;i2++){
                arr[index][0] = arr2[i2][0];
                arr[index++][1] = arr2[i2][1];
            }
        }else{
            for(;i1 < l1; i1++){
                arr[index][0] = arr1[i1][0];
                arr[index++][1] = arr1  [i1][1];
            }
        }
        return arr;
    }
    public static String[] getContent(){
        //读取文件
        File file = new File("F:/input.txt");
        StringBuilder input = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(file);
            char[] buf = new char[1024];
            int size = 0;
            while((size = fileReader.read(buf)) != -1){
                input.append(new String(buf,0,size));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //单词分割
        int len = input.length();
        for(int i = 0; i < len; i++){
            char ch = input.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                input.setCharAt(i, (char) (ch+32));
            }else if(!(ch >= 'a' && ch <= 'z')){
                input.setCharAt(i,' ');
            }
        }
        String[] ins = new String(input).split(" ");
        return ins;
    }
}
