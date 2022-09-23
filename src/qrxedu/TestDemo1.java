package qrxedu;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class TestDemo1 {
    public static void main(String[] args) throws InterruptedException {
        long beg = System.currentTimeMillis();
        Thread t = new Thread(() ->{
           long a = 0;
           for(long i = 0; i < 10_0000;i++){
               System.out.println(1);
               a++;
            }
        });
        t.start();
       long end = System.currentTimeMillis();
        System.out.println(end - beg);
    }
    public static void con() throws InterruptedException {
        long beg = System.currentTimeMillis();

        Thread t = new Thread(() ->{
            long a = 0;
            for(int i = 0; i < 10_0000_0000;i++){
               a++;
            }
        });
        t.start();


        long end = System.currentTimeMillis();
        System.out.println(end - beg);
    }
    public static void main1(String[] args) throws InterruptedException {
        //用线程类创建任务对应的实例
        Thread t0 = new MyThread();
        //用runnable创建任务对应的实例
        Thread t = new MyThread1();
        //执行线程
        t.start();
        //runnable对应的匿名内部类
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello runnable");
            }
        });
        //线程类对应的匿名内部类
        Thread t2 = new Thread(){
            @Override
            public void run() {
                System.out.println("hello thread");
            }
        };
        //runnable对应的lambda表达式形式
        Thread t3 = new Thread(() ->{
            System.out.println("hello runnable");
        });
    }

}
class MyThread extends Thread{
    //为线程分配具体的任务
    @Override
    public void run() {
        System.out.println("hhh");
    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        while(true){
            System.out.println("hello Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
