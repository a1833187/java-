package qrxedu.thread;

/**
 * @author qiu
 * @version 1.8.0
 */
@SuppressWarnings("all")
public class Demo2 {
    public static void main(String[] args) {
        Thread t1 = new MyThreadA();
        Thread t2 = new Thread(new MyThreadB());
        Thread t3 = new Thread(new Thread(){
            @Override
            public void run() {
                System.out.println("This is Thread by 匿名内部类");
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("This is Thread by 匿名内部类");
            }
        });
        Thread t5 = new Thread(()->{
            System.out.println("This is Runnable by lambda");
        });
        Runnable t6 = new Runnable(){
            @Override
            public void run() {
                System.out.println("hh");
            }
        };
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
class MyThreadA extends Thread{
    @Override
    public void run() {
        System.out.println("This is Thread");
    }
}
class MyThreadB implements Runnable{
    @Override
    public void run() {
        System.out.println("This is Runnable");
    }
}
