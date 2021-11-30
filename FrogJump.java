package com.qrxedu;

import org.junit.jupiter.api.Test;

/**
 * @author qiu
 * @version 1.8.0
 */
public class FrogJump {
    public static void main(String[] args) {
        int[] arr = {0};
        int count = 0;
        int n = 5;
        jump(n,arr);
        System.out.println("一共有" + arr[0] + "种跳法");
    }
    public static void jump(int n,int[] arr){
        //青蛙跳台阶问题
        if(n == 0){
            arr[0]++;
            return;
        }
        if(n<0){
            return;
        }
        for(int j = 1; j <= 2;j++){
            jump(n-j,arr);
        }
    }
}
