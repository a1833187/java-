package qrxedu.algorithm.day18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * k个一组反转链表
 * 在输入时将输入的数字保存到一个字符串数组中，这种做法避免了先输入一行字符串，然后对这个字符串中的数字进行
 * 单独的取出，因为要考虑每个数字的位数不一定相同。而且题目有提示说以"#"结尾，所以输入的数字要一个一个输
 * 因为最后以#结尾，所以输入的数字是字符串形式。
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while(true){
            String str = scanner.next();
            if("#".equals(str)){
                break;
            }
            list.add(str);
        }
        int k = scanner.nextInt();
        int start = 0;
        while(start+k-1 < list.size()){
            reverse(list,start,start+k-1);
            start = start + k;
        }
        for(int i = 0; i < list.size()-1; i++){
            System.out.print(list.get(i) + "->");
        }
        System.out.print(list.get(list.size()-1));
    }
    public static void reverse(List<String> list,int start,int end){
        while(start < end){
            String tmp = list.get(start);
            list.remove(start);
            list.add(start,list.get(end-1));
            list.remove(end);
            list.add(end,tmp);
            start++;
            end--;
        }
    }
}
