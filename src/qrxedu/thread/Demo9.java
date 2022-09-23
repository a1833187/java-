package qrxedu.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 线程池里面有多个工作线程用一个数据结构连起来，每个工作线程里有一个阻塞队列，阻塞队列里存放的
 * 是具体的任务
 * @author qiu
 * @version 1.8.0
 */
public class Demo9 {
    public static void main(String[] args) {
        MyThreadPool my = new MyThreadPool(10);
        my.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is a task");
            }
        });
        Thread t = my.getList().get(0);
        t.start();
    }
}
class MyThreadPool{
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    class Worker extends Thread{
        private BlockingQueue<Runnable> q;

        public Worker(BlockingQueue<Runnable> queue){
            q = queue;
        }

        @Override
        public void run() {
            while(true){
                try {
                    Runnable runnable = q.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private List<Worker> list = new ArrayList<>();
    public MyThreadPool(int n){
        for(int i = 0; i < n; i++){
            Worker worker = new Worker(queue);
            worker.start();
            list.add(worker);
        }
    }
    public List<Worker> getList(){
        return list;
    }
    public void submit(Runnable r){
        queue.offer(r);
    }
}
