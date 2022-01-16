package com.qrxedu.lcseries.leedcode6;

import org.junit.jupiter.api.Test;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (s.length()<=numRows||numRows == 1) {
            return s;
        }
        int len = s.length();
        int len1 = 0;
        int l = 0;
        //当字符串的长度构成的z字形串在最后存在"出头"的情况时把它补齐
        while (2 * l * (numRows - 1) < len) {
            l++;
        }
        if (2 * (l - 1) * (numRows - 1) + numRows < len) {
            len1 = 2 * (l + 1) * (numRows - 1);
        } else {
            len1 = len;
        }
        Character[] s1 = new Character[len1];
        for (int i = 0; i < len; i++) {
            s1[i] = s.charAt(i);
        }
        Character[] o = new Character[len1];
        char[] o1 = new char[len];
        int k = 0;
        //行数
        for (int j = 0; j < numRows; j++) {
            //列数
            for (int i = 0; 2 * i * (numRows - 1) < len1; i++) {
                if (j == 0) {
                    //第一行字符
                    o[k++] = s1[2 * i * (numRows - 1)];
                } else {
                    if (i == 0) {
                        //每行第一个字符
                        o[k++] = s1[j];
                    } else if (j == numRows - 1) {
                        //最后一行字符
                        if (2 * i * (numRows - 1) + j < len1) {
                            o[k++] = s1[2 * i * (numRows - 1) + j];
                        }
                    } else {
                        //其余每行的字符
                        if (2 * i * (numRows - 1) - j < len1) {
                            o[k++] = s1[2 * i * (numRows - 1) - j];
                        }
                        if (2 * i * (numRows - 1) + j < len1) {
                            o[k++] = s1[2 * i * (numRows - 1) + j];
                        }
                    }

                }
            }
        }
        int m = 0;
        for (int i = 0; i < len1; i++) {
            if (o[i] != null) {
                o1[m++] = o[i];
            }
        }
        return new String(o1);
    }

    @Test
    public void show() {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }
}
