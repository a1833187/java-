package qrxedu;

import java.util.Objects;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author qiu
 * @version 1.8.0
 */

public class Demo7 {

}
class MyTask implements Comparable<MyTask>{
    private Runnable runnable;
    private long time;
    public MyTask(Runnable runnable,long after){
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + after;
    }
    public void run(){
        runnable.run();
    }
    public long getTime(){
        return time;
    }

    @Override
    public int compareTo(MyTask o) {
        return (int)(this.time - o.time);
    }
}
@SuppressWarnings("all")
class Time{
    private PriorityBlockingQueue<MyTask> p = new PriorityBlockingQueue<>();
    private Object locker = new Object();
    public void schedule(Runnable runnable,long delay){
        MyTask task = new MyTask(runnable,delay);
        p.offer(task);

        synchronized(locker){
            locker.notify();
        }
    }
    public Time(){
        Thread t = new Thread(() -> {
           while(true){
               MyTask task = p.peek();
               long time = System.currentTimeMillis();
               if(task.getTime() >= time){
                   task = p.poll();
                   task.run();
               }else{
                   synchronized(locker) {
                       try {
                           locker.wait(time-task.getTime());
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               }
           }
        });
        t.start();
    }
}
