package qrxedu.sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main {
    List<String> l = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, new StringBuilder());
        return l;
    }

    public void dfs(int n, int diff, StringBuilder s) {
        if (s.length() == n * 2) {
            if (diff == 0) {
                String cur = new String(s);
                l.add(cur);
            }
            return;
        }
        if (diff < n) {
            s.append('(');
            dfs(n, ++diff, s);
            s.deleteCharAt(s.length() - 1);
        }
        if (diff > 0) {
            s.append(')');
            dfs(n, --diff, s);
            s.deleteCharAt(s.length() - 1);
        }

    }

    @Test
    public void show() {
        System.out.println(generateParenthesis(3));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String p = scanner.nextLine();
        String c = scanner.nextLine();
        StringBuffer sb = new StringBuffer(p);
        int i = 0;
        while (i < sb.length()) {
            if (c.contains(sb.charAt(i) + "")) {
                sb.deleteCharAt(i);
            } else {
                i++;
            }
        }
        System.out.println(sb.toString());
    }

    public static boolean isContains(String c, char ch) {
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) == ch) {
                return true;
            }
        }
        return false;
    }

}

