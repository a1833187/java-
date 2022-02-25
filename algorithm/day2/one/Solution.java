package qrxedu.algorithm.day2.one;

/**
 * 将字符串中的空格换成"%20"
 * 手撸，不能调库。
 * 首先要得到新字符串的长度:oldLen + (替换字符长度差) * 替换字符个数
 * 然后根据双指针分别指向原来字符串的末尾和新字符串的末尾，将旧字符串中的字符按规则移动到新字符串中
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String replaceSpace(StringBuffer str){
        int count = 0;
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) == ' '){
                count++;
            }
        }
        int newLen = str.length() + 2 * count;
        int newEnd = newLen - 1;
        int oldEnd = str.length() - 1;
        str.setLength(newLen);
        while(oldEnd >= 0 && newEnd >= 0){
            if(str.charAt(oldEnd) == ' '){
                str.setCharAt(newEnd--,'0');
                str.setCharAt(newEnd--,'2');
                str.setCharAt(newEnd--,'%');
                oldEnd--;
            }else{
                str.setCharAt(newEnd,str.charAt(oldEnd));
                newEnd--;
                oldEnd--;
            }
        }
        return str.toString();
    }
}
