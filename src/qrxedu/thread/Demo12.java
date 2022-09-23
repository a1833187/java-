package qrxedu.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Demo12 {
    public static void main(String[] args) {
        ReentrantLock r = new ReentrantLock();
        r.lock();

        r.unlock();
    }
}
