package qrxedu.lcseries.leedcode13;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 'M') {
                res += 1000;
            }else if (i + 1 < len && arr[i] == 'C' && arr[i + 1] == 'M') {
                res += 900;
                i += 1;
            } else if (arr[i] == 'D') {
                res += 500;
            }else if (i + 1 < len && arr[i] == 'C' && arr[i + 1] == 'D') {
                res += 400;
                i += 1;
            }  else if (arr[i] == 'C') {
                res += 100;
            }else if (i + 1 < len && arr[i] == 'X' && arr[i + 1] == 'C') {
                res += 90;
                i += 1;
            } else if (arr[i] == 'L') {
                res += 50;
            }else if (i + 1 < len && arr[i] == 'X' && arr[i + 1] == 'L') {
                res += 40;
                i += 1;
            } else if (arr[i] == 'X') {
                res += 10;
            }else if (i + 1 < len && arr[i] == 'I' && arr[i + 1] == 'X') {
                res += 9;
                i += 1;
            } else if (arr[i] == 'V') {
                res += 5;
            } else if (i + 1 < len && arr[i] == 'I' && arr[i + 1] == 'V') {
                res += 4;
                i += 1;
            } else if (arr[i] == 'I') {
                res += 1;
            }
        }
        return res;
    }
    }
