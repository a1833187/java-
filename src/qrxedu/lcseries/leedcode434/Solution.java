package qrxedu.lcseries.leedcode434;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int countSegments(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            //除去第一个单词，剩下的一个空格对应一个单词
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }

        return count;
    }
}
