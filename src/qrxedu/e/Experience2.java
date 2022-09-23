package qrxedu.e;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Experience2 {
    public static void show(String[] s, String[] ans1) {
        int is = 0, i1 = 0;
        int m = s.length;
        while (is < m) {
            if (s[is].equals(ans1[i1])) {
                is++;
                i1++;
            } else {
                if (ans1[i1] == null) {
                    ans1[i1] = s[is];
                    is++;
                    i1++;
                } else if ("-".equals(ans1[i1])) {
                    while ("-".equals(ans1[i1])) {
                        i1++;
                    }
                } else {
                    i1++;
                    is++;
                }
            }
        }
        for (int i = 0; i < ans1.length; i++) {
            if (ans1[i] == null) {
                break;
            }
            System.out.printf("%-11s", ans1[i] + " ");
        }
    }

    public static void main(String[] args) {
        String[] ic = handleIn();
        ic[0] = ic[0].toLowerCase();
        ic[1] = ic[1].toLowerCase();
        String[] ins = ic[0].split("\\.");
        String[] cos = ic[1].split("\\.");
        for (int j = 0; j < ins.length; j++) {
            String in = ins[j];
            int len = 1;
            int m = in.length();
            for (int i = 0; i < m; i++) {
                if (in.charAt(i) == ' ') {
                    len++;
                }
            }
            int n = cos.length;
            double ans = 0;
            String[] s = in.split(" ");
            for (int i = 0; i < n; i++) {
                String[] t = cos[i].split(" ");
                m = s.length;
                int n1 = t.length;
                String[][] flag = new String[m][n1];
                int[][] f = new int[m][n1];
                int l1 = getLCS(s, t, flag, f);
                if (ans < l1 * 1.0 / len) {
                    ans = l1 * 1.0 / len;
                    if (ans >= 0.4) {
                        System.out.print("查重率为:");
                        System.out.printf("%.2f",ans*100);
                        System.out.println("%");
                        //根据flag输出这个查重的句子
                        //先得到对应的flag[i][j]为"lu"的i,j,
                        int[][] getAns = new int[m][2];
                        for (int ii = 0; ii < m; ii++) {
                            Arrays.fill(getAns[ii], -1);
                        }
                        int i1 = m - 1, j1 = n1 - 1, idx = m - 1;
                        while (i1 >= 0 && j1 >= 0) {
                            if ("lu".equals(flag[i1][j1])) {
                                getAns[idx][0] = i1;
                                getAns[idx][1] = j1;
                                idx--;
                                i1--;
                                j1--;
                            } else if ("l".equals(flag[i1][j1])) {
                                j1--;
                            } else if ("u".equals(flag[i1][j1])) {
                                i1--;
                            }
                        }
                        String[] ans1 = new String[1000];
                        String[] ans2 = new String[1000];
                        int tmp0 = 0;
                        int tmp1 = 0;
                        for (int i2 = 0; i2 < m; i2++) {
                            if (getAns[i2][0] == -1 && getAns[i2][1] == -1) {
                                continue;
                            }
                            i1 = getAns[i2][0];
                            j1 = getAns[i2][1];
                            if (i1 > j1) {
                                ans1[i1] = s[i1 - tmp0];
                                ans2[i1] = t[j1 - tmp1];
                                for (int i3 = i1 - 1; i3 >= j1; i3--) {
                                    ans2[i3] = "-";
                                }
                                for (int i3 = i2 + 1; i3 < m; i3++) {
                                     getAns[i3][1] += i1 - j1;
                                }
                                tmp1 += i1 - j1;
                            } else if (i1 < j1) {
                                ans1[j1] = s[i1 - tmp0];
                                ans2[j1] = t[j1 - tmp1];
                                for (int i3 = j1 - 1; i3 >= i1; i3--) {
                                    ans1[i3] = "-";
                                }
                                for (int i3 = i2 + 1; i3 < m; i3++) {
                                    getAns[i3][0] += j1 - i1;
                                }
                                tmp0 += j1 - i1;
                            } else {
                                ans1[i1] = s[i1 - tmp0];
                                ans2[i1] = t[j1 - tmp1];
                            }
                        }
                        show(s, ans1);
                        System.out.println();
                        show(t, ans2);
                        System.out.println();
                    }
                }
            }
        }

    }

    public static int getLCS(String[] s, String[] t, String[][] flag, int[][] f) {
        int m = s.length;
        int n = t.length;
        if (s[0].equals(t[0])) {
            f[0][0] = 1;
            flag[0][0] = "lu";
        } else {
            flag[0][0] = "u";
        }
        for (int i = 1; i < m; i++) {
            if (s[i].equals(t[0])) {
                f[i][0] = 1;
                flag[i][0] = "lu";
            }
            if (f[i - 1][0] >= f[i][0]) {
                f[i][0] = f[i - 1][0];
                flag[i][0] = "u";
            }
        }
        for (int i = 1; i < n; i++) {
            if (t[i].equals(s[0])) {
                f[0][i] = 1;
                flag[0][i] = "lu";
            }
            if (f[0][i - 1] >= f[0][i]) {
                f[0][i] = f[0][i - 1];
                flag[0][i] = "l";
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s[i].equals(t[j])) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    flag[i][j] = "lu";
                } else if (f[i - 1][j] >= f[i][j - 1]) {
                    f[i][j] = f[i - 1][j];
                    flag[i][j] = "u";
                } else {
                    f[i][j] = f[i][j - 1];
                    flag[i][j] = "l";
                }
            }
        }
        return f[m - 1][n - 1];
    }

    public static String[] handleIn() {
        File fileIn = new File("F:/text.txt");
        File fileCo = new File("F:/lib.txt");
        StringBuilder in = new StringBuilder();
        StringBuilder co = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(fileIn);
            FileReader fileReader1 = new FileReader(fileCo);
            char[] buf = new char[1024];
            char[] buf1 = new char[1024];
            int size = 0;
            while ((size = fileReader.read(buf)) != -1) {
                in.append(new String(buf, 0, size));
            }
            size = 0;
            while ((size = fileReader1.read(buf1)) != -1) {
                co.append(new String(buf1, 0, size));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[]{new String(in), new String(co)};
    }

//    public static void main(String[] args) {
//        String[] s = {"learning", "allows", "computers", "to", "identify", "hidden",
//                "insights", "and", "patterns", "without", "being", "explicitly", "programmed", "where", "to", "look"};
//        String[] t = {"hello", "learning", "allows", "computers", "to", "find", "hidden",
//                "insights", "without", "being", "explicitly", "programmed", "where", "to", "look"};
//        int m = s.length;
//        int n = t.length;
//        String[][] flag = new String[m][n];
//        int[][] f = new int[m][n];
//        int l1 = getLCS(s, t, flag, f);
//        System.out.print("查重率为:");
//        System.out.printf("%.2f",l1*1.0/m*100);
//        System.out.println("%");
//        int[][] getAns = new int[m][2];
//        for (int ii = 0; ii < m; ii++) {
//            Arrays.fill(getAns[ii], -1);
//        }
//        int i1 = m - 1, j1 = n - 1, idx = m - 1;
//        while (i1 >= 0 && j1 >= 0) {
//            if ("lu".equals(flag[i1][j1])) {
//                getAns[idx][0] = i1;
//                getAns[idx][1] = j1;
//                idx--;
//                i1--;
//                j1--;
//            } else if ("l".equals(flag[i1][j1])) {
//                j1--;
//            } else if ("u".equals(flag[i1][j1])) {
//                i1--;
//            }
//        }
//        int le = Math.max(m, n);
//        String[] ans1 = new String[1000];
//        String[] ans2 = new String[1000];
////                        for(int i2 = 0; i2 < m; i2++){
////                            ans1[i2] = s[i2];
////                        }
////                        for(int i2 = 0; i2 < n; i2++){
////                            ans2[i2] = t[i2];
////                        }
//        int tmp0 = 0;
//        int tmp1 = 0;
//        for (int i2 = 0; i2 < m; i2++) {
//            if (getAns[i2][0] == -1 && getAns[i2][1] == -1) {
//                continue;
//            }
//            i1 = getAns[i2][0];
//            j1 = getAns[i2][1];
//            if (i1 > j1) {
//                ans1[i1] = s[i1 - tmp0];
//                ans2[i1] = t[j1 - tmp1];
//                for (int i3 = i1 - 1; i3 >= j1; i3--) {
//                    ans2[i3] = "-";
//                }
//                for (int i3 = i2 + 1; i3 < m; i3++) {
//                    getAns[i3][1] += i1 - j1;
//                }
//                tmp1 += i1 - j1;
//            } else if (i1 < j1) {
//                ans1[j1] = s[i1 - tmp0];
//                ans2[j1] = t[j1 - tmp1];
//                for (int i3 = j1 - 1; i3 >= i1; i3--) {
//                    ans1[i3] = "-";
//                }
//                for (int i3 = i2 + 1; i3 < m; i3++) {
//                    getAns[i3][0] += j1 - i1;
//                }
//                tmp0 += j1 - i1;
//            } else {
//                ans1[i1] = s[i1 - tmp0];
//                ans2[i1] = t[i1 - tmp1];
//            }
//        }
////        for(int i2 = 0; i2 < le; i2++){
////            System.out.print(ans1[i2] + " ");
////        }
////        System.out.println();
////        for(int i2 = 0; i2 < le; i2++){
////            System.out.print(ans2[i2] + " ");
////        }
//        show(s, ans1);
//        System.out.println();
//        show(t, ans2);
//
//    }
}