package qrxedu.lcseries.leedcode423;

/**
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按升序返回原始的数字
 * @author qiu
 * @version 1.8.0
 * 按每个数字对应的英文字母中出现的特殊字符去决定该数字是否存在
 * 要按从小到大找,并且优先找只存在1个的:如three 找t、h、r，不找e
 */
public class Solution {
    public String originalDigits(String s) {
        int[] num = new int[10];
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == 'z'){
                num[0]++;
            }
            if(s.charAt(i) == 'w'){
                num[2]++;
            }
            if(s.charAt(i) == 'u'){
                num[4]++;
            }
            if(s.charAt(i) == 'x'){
                num[6]++;
            }
            if(s.charAt(i) == 'g'){
                num[8]++;
            }
            if(s.charAt(i) == 'h'){
                num[3]++;
            }
            if(s.charAt(i) == 'f'){
                num[5]++;
            }
            if(s.charAt(i) == 's'){
                num[7]++;
            }
            if(s.charAt(i) == 'i'){
                num[9]++;
            }
            if(s.charAt(i) == 'o'){
                num[1]++;
            }
        }
        num[3] = num[3] - num[8];
        num[5] = num[5] - num[4];
        num[7] = num[7] - num[6];
        num[9] = num[9] -num[5] -num[6] - num[8];
        num[1] = num[1] - num[0] - num[2] - num[4];
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for(int i = 0; i < 10;i++){
            for(int j = 0; j < num[i]; j++){
                sb.append(k);
            }
            k++;
        }
        return new String(sb);
    }
}
