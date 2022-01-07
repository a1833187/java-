package com.qrxedu;

/**
 * @author qiu
 * @version 1.8.0
 */
public class TestString {
    static final String str1 = "123";
    static final String str2;
    static {
        str2 = "456";
        s = "123" + str2;
    }
    static String s;

    public static void main(String[] args) {
       /* System.out.println(s == "123456");
        {
            String s = str1 + "456";
            System.out.println(s == "123456");
        }
        String s = "123" + str2;
        System.out.println(s == "123456");*/
        /*{
            String s= str1 + str2;
            System.out.println(s == "123456");
        }*/
       /* String s11 = str1 + "456";
        System.out.println(s11 == "123456");
        String s1 = "456";
        String s2 = "123";
        String s = s1 + "456";
        System.out.println(s == "123456");*/
        String s = "123" + str1;
        System.out.println(s == "123123");
    }
}
