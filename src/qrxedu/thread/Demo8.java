package qrxedu.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Demo8 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(20);
        for(int i = 0; i < 10; i++){
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hh");
                }
            });
        }
    }
}
