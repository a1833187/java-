package qrxedu.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author qiu
 * @version 1.8.0
 */
public class Demo6 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hh");
            }
        },3000);
        System.out.println("hello");
    }
}
