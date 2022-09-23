package qrxedu.wexam;

import qrxedu.lcseries.leedcode707.MyLinkedList;

import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main61 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        String[] ss1 = s1[0].split("/");
        String[] ss2 = s1[1].split("/");
        long n1 = Long.parseLong(ss1[0]);
        long n2 = Long.parseLong(ss1[1]);
        long n3 = Long.parseLong(ss2[0]);
        long n4 = Long.parseLong(ss2[1]);
        long sum = 0,diff = 0,pro = 0,quo = 0;





    }
    public void operation1(long n1,long n2,long n3,long n4,char ch){
        long ip1 = n1/n2;
        long sp1 = n1%n2;
        long ip2 = n2/n3;
        long sp2 = n2%n3;

        long cur2 = 0;
        if(ch == '+'){
            cur2 = n1*n3+n2*n4;
        }else if(ch == '-'){
            cur2 = n1*n3-n2+n4;
        }
        long cur1 = getGcd(cur2,n4*n2);
        long fm1 = n2*n4/cur1;
        long fz1 = cur2/cur1;
        long ansIp1 = fz1/fm1;
        long ansSp1 = fz1%fm1;
        if(ip1 != 0){
            System.out.print(ip1 + " ");
        }
        if(sp1 == 0){
            System.out.print(0 + " " + ch + " ");
        }else{
            System.out.print(sp1 + "/" + n2 + " " + ch + " ");
        }
        if(ip2 != 0){
            System.out.print(ip2 + " ");
        }
        if(sp2 == 0){
            System.out.print(0 + " " + "= ");
        }else{
            System.out.print(sp1 + "/" + n2 + " = ");
        }
        if(ansIp1 != 0){
            System.out.print(ansIp1 + " ");
        }
        if(ansSp1 == 0){
            System.out.println(0);
        }else{
            System.out.println(ansSp1 + "/" + fm1);
        }
    }
    public void operation2(){

    }
    public static long getGcd(long n1,long n2){
        long ans = n1 * n2;
        long max = Math.max(n1,n2);
        long min = Math.min(n1,n2);
        long r = max % min;
        while(r != 0){
            max = min;
            min = r;
            r = max % min;
        }
        return min;
    }
}
