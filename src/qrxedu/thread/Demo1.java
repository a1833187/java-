package qrxedu.thread;

import java.util.Random;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
class A{
    static Object locker  = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() ->{
            synchronized (locker){
                System.out.println("执行任务A");
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("等待结束");
                System.out.println("执行任务B");
            }
        });
        Thread t2 = new Thread(() ->{
            synchronized(locker){
                locker.notify();
                System.out.println("执行任务C");
            }
        });
        t1.start();
        t2.start();
    }
}
class SynchronizedDemo{
    synchronized public void func(){
        System.out.println("给普通方法加锁");
    }
    synchronized static public void func1(){
        System.out.println("给静态方法加锁");
    }
    public void func2(){
        //给当前对象加锁
        synchronized (this){
            System.out.println("给普通方法通过代码块的方式加锁");
        }
    }
    static public void func3(){
        //给类对象加锁
        synchronized (SynchronizedDemo.class){
            System.out.println("给静态方法通过代码块的方式加锁");
        }
    }
}
@SuppressWarnings("all")
public class Demo1 {
    //状态：NEW: 线程创建了但是没有启动
    // RUNNABLE：run方法执行
    // TERMINATED：run方法执行完后的状态
    // TIME_WAITTING：run方法执行的时候执行完仍在阻塞时的状态
    // BLOCKED ：加锁时的状态
    // WAITTING：调用wait方法时的状态
    public static long res1 = 0;
    public static long res2 = 0;
    static int count = 0;
    static Object locker = new Object();

    public static void main(String[] args) throws InterruptedException {
       Thread t = new Thread(() -> {
           synchronized (Thread.currentThread()){
               System.out.println("执行任务A");
               try {
                   Thread.currentThread().wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("等待结束");
               System.out.println("执行任务B");
           }
       });

    }
    public static void func(int[] arr) throws InterruptedException {
        long beg = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < arr.length;i+=2){
                res1 +=arr[i];
            }
        });
        t1.start();
        Thread t2 = new Thread(()->{
           for(int i = 1; i < arr.length;i+=2){
               res2+=arr[i];
           }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println("数组的所有元素的和为：" + (res1+res2));
        long end = System.currentTimeMillis();
        System.out.println("线程运行时间为：" + (end - beg) + "ms");
    }
    /*
     线程安全：面试常考！！
     多线程
     线程中调用count++一共3个步骤：
     1. 将内存其中的值存入到CPU的寄存器中 (load)
     2. 将CPU寄存器中读取的count+1 (add)
     3. 将CPU寄存器中的值写回到内存 (save)
     两个线程进行三个步骤的顺序充满随机性，有很大可能出现先load的进程还没有将修改的值存到寄存器(save)中，
     后面的线程就抢先load原来的count值，这样两次 synchronized
     自增自增的都是原来的count值
     */

    /*
    产生线程不安全的原因：
    1. 线程是抢占式进行的，线程间的调度充满随机性(线程不安全的万恶之源)
    2. 多个线程对同一个变量进行数据的更新操作
    3. 针对的变量的操作不是原子(不可分割，执行的操作统一执行)    (加锁就是将几条操作打包成一个原子)
    4. 内存可见性：在某些特殊情况下，线程本来要读取内存中的数据，但改变成了读取CPU寄存器中的数据
    volatile可以防止内存可见性和指令重排序，但不能保证原子性
    内存可见性属于编译器优化的副作用
    5. 指令重排序：编译器优化的副作用：编译器会在保证逻辑不变的情况下去调整某些指令的运行顺序来提高程序的效率，
    但对于多线程而言，该优化可能导致误判。
     */

    /*
    synchronized 对实例方法加锁 和对 类方法加锁有什么区别？
     */
}
