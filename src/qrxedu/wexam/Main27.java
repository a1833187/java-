package qrxedu.wexam;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split("-");
        //不能用字符串长度比较,因为即使是同一类型也不一定长度就相同,因为 有 "10"
        //有joker就直接输出joker就行
        //要用空格分成字符串数组,数组对应长度 为 比较规则.
        String l = arr[0];
        String r = arr[1];
        String big = "joker JOKER";
        if (l.equals(big) || r.equals(big)) {
            System.out.println(big);
            return;
        }
        //
        String[] cmp = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "joker", "JOKER"};
        String[] ll = l.split(" ");
        String[] rr = r.split(" ");
        if(ll.length == 4 && rr.length != 4){
            System.out.println(l);
            return;
        }
        if(rr.length == 4 && ll.length != 4){
            System.out.println(r);
            return;
        }
        System.out.println(print(cmp,l,r));

    }

    public static String print(String[] cmp, String l, String r) {
        String[] ll = l.split(" ");
        String[] rr = r.split(" ");
        if(ll.length != rr.length){
            return "ERROR";
        }
        int lc = isContains(cmp,ll[0]);
        int rc = isContains(cmp,rr[0]);
        if (lc != -1 && rc != -1) {
            if (lc > rc) {
                return l;
            } else {
                return r;
            }
        }
        return "ERROR";
    }

    public static int isContains(String[] cmp, String key) {
        for (int i = 0; i < cmp.length; i++) {
            if (key.equals(cmp[i])) {
                return i;
            }
        }
        return -1;
    }
}
