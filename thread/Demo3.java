package qrxedu;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Demo3 {
    //单例模式
    /* 饿汉模式：饿汉表示着急的意思，表示马上去实现单例的意思
       懒汉模式：懒汉表示不着急的意思，表示当前不做处理，在之后必须进行处理的时候再做处理
       在需要的时候再创建实例
       在计算机中，懒是一个褒义词，懒意味着 更高效
     */
    int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Demo3 d = new Demo3();
        Thread t1 = new Thread(() -> {
            synchronized (d) {
                for (int i = 0; i < 50000; i++) {
                    d.count++;
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            synchronized (d) {
                for (int i = 0; i < 50000; i++) {
                    d.count++;
                }
            }
        });
        t2.start();
        t1.join();
        t2.join();
        System.out.println(d.count);
    }
}
class Singleton{
    /**
     *饿汉模式:线程安全，但效率比较低
     */
    private static Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }
}
class Singleton2{
    /**
     * 懒汉模式：效率高但线程不安全
     */
    private static  volatile  Singleton2 instance = null;
    private Singleton2(){}

    public static Singleton2 getInstance(){
        /**
         * 在外层加一个条件判断用来告知线程当instance已经初始化后就无需再进行锁竞争
         * 但是如果大量进程读外层循环可能会造成内存可见性问题，这个问题会导致 不该加锁的进程依旧加锁了
         * 解决方法是给instance类对象加上volatile
         */
        if(instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
