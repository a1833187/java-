package qrxedu.lcseries.leedcode467;

import org.junit.jupiter.api.Test;

/**
 * 环绕字符串中的唯一子字符串
 * abcde = a:1 + b:2 + c:3 + d:4 + e:5这样遍历能保证唯一
 * 错误：a-e:5+4+3+2+1
 * @author qiu
 * @version 1.8.0
 */
public class Solution {
    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int[] cur = new int[p.length()];
        for (int i = 0; i < p.length(); i++) {
            cur[i] = p.charAt(i) - 'a';
        }
        int res = 0;
        for (int j = 0; j < cur.length; j++) {
            int sum = 1;
            if (j < cur.length-1 && (cur[j] + 1) % 26 == cur[j + 1]) {
                sum++;
            } else {
                break;
            }
            count[p.charAt(j) - 'a'] = Math.max(count[p.charAt(j) - 'a'], sum);
        }

        for (int i = 0; i < count.length; i++) {
            res += count[i];
        }
        return res;
    }

    public int func(int n) {
        int m = n;
        int sum = 0;
        while (m != 0) {
            sum += m;
            m--;
        }
        return sum - n;
    }

    @Test
    public void show() {
        System.out.println(findSubstringInWraproundString("abcd"));
    }
}
