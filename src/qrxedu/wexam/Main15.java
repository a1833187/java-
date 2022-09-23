package qrxedu.wexam;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Main15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int cnt = 0;
        int countNum = 0;
        int countA = 0;
        int counta = 0;
        int countOther = 0;
        if(str.length() <= 4){
            cnt+=5;
        }else if(str.length() <= 7){
            cnt+=10;
        }else{
            cnt+=25;
        }
        for(int i = 0;i < str.length();i++){
            char ch = str.charAt(i);
            if(ch >= '0' && ch <= '9'){
                countNum++;
            }else if((ch >= 'a' && ch <= 'z')){
                counta++;
            }else if(ch >= 'A' && ch <= 'Z'){
                countA++;
            }else{
                countOther++;
            }
        }
        if(countNum == 1){
            cnt+=10;
        }else if(countNum > 1){
            cnt += 20;
        }
        if(countOther == 1){
            cnt+=10;
        }else if(countOther > 1){
            cnt += 25;
        }
        if(countA + counta > 0){
            if(countA == 0  || counta == 0){
                cnt+=10;
            }else{
                cnt+=20;
            }
        }
        if(counta!= 0 && countA!= 0 && countNum != 0 && countOther!=0){
            cnt +=5;
        }else if(countNum != 0 && countOther != 0 && (counta != 0 || countA != 0)){
            cnt +=3;
        }else if(countNum != 0 && (counta != 0 || countA != 0)){
            cnt += 2;
        }
        if(cnt >= 90){
            System.out.println("VERY_SECURE");
            return;
        }
        if(cnt >= 80){
            System.out.println("SECURE");
            return;
        }
        if(cnt >= 70){
            System.out.println("VERY_STRONG");
            return;
        }
        if(cnt >= 60){
            System.out.println("STRONG");
            return;
        }
        if(cnt >= 50){
            System.out.println("AVERAGE");
            return;
        }
        if(cnt >= 25){
            System.out.println("WEAK");
            return;
        }
        if(cnt >= 0){
            System.out.println("VERY_WEAK");
        }
    }
    @Test
    public void show(){

    }
}
