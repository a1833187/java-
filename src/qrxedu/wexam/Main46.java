package qrxedu.wexam;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * 猴子分桃
 * 你被猴子耍过....
 * n个猴子,每个猴子把桃子均分成5份后,刚好剩下1个分给老猴子,分完后每个猴子取走均分的1份,依次往下,知道所有猴子取到自己
 * 应该拿的桃子数之后把剩余的桃子分给老猴子.问这堆桃子最少有多少个,老猴子最后至少能拿多少个桃子.
 *
 * 煞笔做法:模拟.....(ε=(´ο｀*)))唉)
 * 正确做法:因为每次分桃子都会多出来1个,所以刚开始的时候借给猴子4个桃子,使这堆桃子可以被均分成5份,这样猴子拿到的猴子
 * 刚好是原来的个数加1个,然后新的情景下我们规定每次猴子拿到自己的桃子以后分给老猴子1个.所以给第二个桃子剩下的桃子的数量和没借桃子之前
 * 给第二个猴子剩余的桃子数量刚好多4个(因为总桃子数多了4个,然后第一个猴子和老猴子拿到的桃子的数量并没有变)
 * 这样依次往下每个猴子都可以把桃子数均分成5份.
 * 所以最后剩余的桃子数量为(x+4)*(4/5)^n,要求x最小且最后剩下的桃子必须为整数,所以x+4=5^n,剩下的桃子数为4^n
 * 所以原来的桃子数量x = 5^n-4.老猴子拿到的桃子数:4^n-4+n(每轮老猴子都能分1个)
 * @author qiu
 * @version 1.8.0
 */
public class Main46 {
    static long[] f = new long[20];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            if(n == 0){
                break;
            }
            if(n == 1){
                System.out.println("1 1");
                continue;
            }
            if(n == 20){
                System.out.println();
                continue;
            }
            long k = 4;
            while(!isValid(f,k)){
                k+=4;
            }
            System.out.println(f[n-1] + " " + ((f[0]-1)/5*4+n));
        }
    }
    public static boolean isValid(long[] f,long k){
        f[0] = k*5/4+1;
        for(int i = 1; i < f.length; i++){
            if(5L*f[i-1]%4==0){
                f[i] = 5*f[i-1]/4+1;
            }else{
                return false;
            }
        }
        return true;
    }
//    @Test
//    public void show(){
//        System.out.println(621*625+369*4);
//        System.out.println(256*621);
//    }
//long k = 1;
//    long num = 0;
//            for(int i = 1; i <= n-2; i++){
//        k = k * 5 + (long)Math.pow(4,i);
//    }
//    k = k * 4;
//    num = (long)Math.pow(5,n-1);
//    long r = (long)Math.pow(4,n-1);
//    long x = 1;
//            while((num*x+k)%r != 0){
//        x++;
//    }
//            System.out.println(x);
//            System.out.println((num*x+k)/r + " " + ((x-1)*4/5+n));
}
