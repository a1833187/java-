package qrxedu.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Demo11 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 通过Callable 来描述一个任务
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };

        // 为了让线程取执行 Callable 中的方法，需要辅助一个类
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread a = new Thread(futureTask);
        a.start();
        System.out.println(futureTask.get());
    }
}
