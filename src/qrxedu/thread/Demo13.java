package qrxedu.thread;

import java.util.concurrent.Semaphore;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Demo13 {
    public static void main(String[] args) throws InterruptedException {
        //初始时分配4个可用资源。
        Semaphore s = new Semaphore(4);
        //一次申请2个资源
        s.acquire(2);
        //当申请的资源数多余初始的可用资源时，会出发阻塞
        //一次释放1个资源
        s.release(1);
        //当正在运行的资源数为0时，再释放会触发阻塞
    }
}
